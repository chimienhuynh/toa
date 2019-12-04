package com.bluesky.toa.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bluesky.toa.R;
import com.bluesky.toa.data.utils.CircleTransform;
import com.bluesky.toa.data.utils.ObjectBox;
import com.bluesky.toa.ui.chat.models.User;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.objectbox.Box;

public class ProfileEditGuru extends AppCompatActivity {
    ImageView iv_back;
    CircleImageView editcircular_image;
    EditText mNameEt, mLocationEt, mBioEt, mCompanyNameEt, mDescriptionEt;
    RadioGroup mGenderRg;
    Spinner mServiceSpinner, mTypeSpinner;
    int servicePosition, typePosition;
    Button mUpdateButton;
    RadioButton mRadioButton;
    byte[] imgArray;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit_guru);

        sharedPreferences = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);

        editcircular_image = findViewById(R.id.edit_circular_image);
        iv_back = findViewById(R.id.iv_back_guruprofileedit);
        mNameEt = findViewById(R.id.name_et);
        mLocationEt = findViewById(R.id.location_et);
        mBioEt = findViewById(R.id.bio_et);
        mCompanyNameEt = findViewById(R.id.company_name_et);
        mDescriptionEt = findViewById(R.id.description_et);
        mGenderRg = findViewById(R.id.gender_rg);
        mServiceSpinner = findViewById(R.id.service_spinner);
        mTypeSpinner = findViewById(R.id.project_type_spinner);
        mUpdateButton = findViewById(R.id.update_button);

        updateViews();

        editcircular_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mServiceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                servicePosition = i;
                Log.e("Position", "Service Position->" + servicePosition);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                typePosition = i;
                Log.e("Position", "Type Position->" + typePosition);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProfile();
            }
        });


    }

    private void updateProfile() {
        String name = mNameEt.getText().toString();
        String location = mLocationEt.getText().toString();
        String bio = mBioEt.getText().toString();
        String company = mCompanyNameEt.getText().toString();
        String description = mDescriptionEt.getText().toString();
        int selectedId = mGenderRg.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        mRadioButton = findViewById(selectedId);

        if (name == null || TextUtils.isEmpty(name)) {
            showToast("Please enter name");
        } else if (location == null || TextUtils.isEmpty(location)) {
            showToast("Please enter location");
        } else if (bio == null || TextUtils.isEmpty(bio)) {
            showToast("Please enter brief bio");
        } else if (company == null || TextUtils.isEmpty(company)) {
            showToast("Please enter company name");
        } else if (description == null || TextUtils.isEmpty(description)) {
            showToast("Please enter company description");
        } else if(mRadioButton == null){
            showToast("Please enter gender");
        } else {
            String gender = mRadioButton.getText().toString();

            User user = new User(name, location, gender, bio, company, servicePosition, typePosition, description, imgArray);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String json = new Gson().toJson(user);
            edit.putString(Constants.GURU_SHARED, json);
            edit.apply();
            setResult(RESULT_OK);
            finish();
            //userBox.put(user);
        }
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void checkPermission() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            // do you work now
                            CropImage.activity()
                                    .setGuidelines(CropImageView.Guidelines.ON)
                                    .start(ProfileEditGuru.this);
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            showSettingsDialog();
                            // permission is denied permenantly, navigate user to app settings
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<com.karumi.dexter.listener.PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }

                })
                .onSameThread()
                .check();

    }

    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Need Permissions");
        builder.setMessage("App needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {
                    Uri resultUri = result.getUri();
                    Picasso.get().load(resultUri).transform(new CircleTransform()).placeholder(R.drawable.user_p)
                            .into(editcircular_image);
                    InputStream iStream = null;
                    try {
                        iStream = getContentResolver().openInputStream(resultUri);
                        imgArray = getBytes(iStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                   /* if (resultUri != null) {
                        //mProfilePicUpdated = true;
                        mImageUri = resultUri;
                    }*/
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Exception error = result.getError();
                    error.printStackTrace();
                }
            }
        }
    }

    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }

    private void updateViews() {
        User user = new Gson().fromJson(sharedPreferences.getString(Constants.GURU_SHARED, null), User.class);
        if (user != null) {
            mNameEt.setText(user.getName());
            mLocationEt.setText(user.getLocation());
            mBioEt.setText(user.getBio());
            mCompanyNameEt.setText(user.getCompany_name());
//            mGenderTv.setText(user.getGender());
            mServiceSpinner.setSelection(user.getService());
            mTypeSpinner.setSelection(user.getProject_type());
            mDescriptionEt.setText(user.getDescription());
            if (user.getImage() != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(user.getImage(), 0, user.getImage().length);
                editcircular_image.setImageBitmap(bitmap);
            }
        }
    }
}

package com.bluesky.toa.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bluesky.toa.R;

import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME= "LoginActivity";
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");

       email = (EditText)(findViewById(R.id.email));
       password = (EditText)(findViewById(R.id.password));

        SharedPreferences sharedPreferences = getSharedPreferences("email", Context.MODE_PRIVATE);
        sharedPreferences.getString("DefaultEmail","email@domain.com");

        Button button= (Button)(findViewById(R.id.login));
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(isValidEmailId(email.getText().toString().trim())){
            //Toast.makeText(getApplicationContext(), "Valid Email Address.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "InValid Email Address.", Toast.LENGTH_SHORT).show();
        }
//                Account queryAccount = (Account) realmDBHelper.find("email", email.getText().toString().trim(), Account.class);
//
//                if (queryAccount != null) {
//                    String accountPassword = queryAccount.getPassword();
//                    Log.i(ACTIVITY_NAME, "Password for " +  email.getText().toString().trim() + " is " + accountPassword + " and password entered is " + password.getText().toString().trim());
//                    if (password.getText().toString().trim().equals(accountPassword)) {
//                        Intent intent = new Intent(LoginActivity.this,HomePageActivity.class);
//                        startActivity(intent);
//                    }
//                    else {
//                        Toast.makeText(getApplicationContext(), "Wrong password, Try again!", Toast.LENGTH_SHORT).show();
//                        password.setText("");
//                    }
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "No account, Please sign up first!", Toast.LENGTH_SHORT).show();
//                    password.setText("");
//                }
            }
        });

    }
    //https://stackoverflow.com/questions/12947620/email-address-validation-in-android-on-edittext
    private boolean isValidEmailId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME,"In onResume()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME,"In onStart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME,"In onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME,"In onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"In onDestroy()");
    }
}

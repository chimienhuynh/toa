package com.bluesky.toa.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bluesky.toa.R;

public class SupportActivity extends AppCompatActivity {


    ImageView iv_back;
    LinearLayout ll_phone;
    Button bt_Send;
    EditText et_name;
    EditText et_email;
    EditText et_essage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        iv_back = (ImageView) findViewById(R.id.iv_back_support);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        bt_Send = (Button) findViewById(R.id.bt_Send);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_essage = (EditText) findViewById(R.id.et_message);
        ll_phone = (LinearLayout) findViewById(R.id.ll_phone);
        bt_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString().trim();
                String email = et_email.getText().toString().trim();
                String mess = et_essage.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(mess)) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822"); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@jessylscharm.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Enquiry");
                    intent.putExtra(Intent.EXTRA_TEXT, name + " " + email + " " + mess);
                    startActivity(intent);
                }
            }
        });
        ll_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "6138753799"));
                startActivity(intent);
            }
        });
    }
}

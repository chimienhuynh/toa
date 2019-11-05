package com.bluesky.toa.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.bluesky.toa.R;

public class SignUpActivity extends Activity {

    EditText name;
    EditText email;
    EditText password;
    CheckBox professional;
    CheckBox customer;
    TextView back_to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) (findViewById(R.id.name));
        email = (EditText) (findViewById(R.id.email));
        password = (EditText) (findViewById(R.id.password));
        professional = (CheckBox) (findViewById(R.id.professional_register));
        customer = (CheckBox) (findViewById(R.id.customer_register));


        back_to_login = (TextView) (findViewById(R.id.login_again));
        back_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.professional_register:
          professional.setChecked(true);
          customer.setChecked(false);

                break;
            case R.id.customer_register:
                professional.setChecked(false);
                customer.setChecked(true);
                break;

        }
    }
}
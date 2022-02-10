package com.example.konfidenciaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PersonalAccountActivity extends AppCompatActivity {

    private TextView full_name;
    private TextView first_name;
    private TextView middle_name;
    private TextView last_name;
    private TextView birthday;
    private TextView sex;
    private TextView email;
    private TextView mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_account);

        Bundle extras = getIntent().getExtras();

        String full_name = extras.getString("full_name");
        String first_name = extras.getString("first_name");
        String middle_name = extras.getString("middle_name");
        String last_name = extras.getString("last_name");
        String birthday = extras.getString("birthday");
        String sex = extras.getString("sex");
        String email = extras.getString("email");
        String mobile = extras.getString("mobile");


        this.full_name = findViewById(R.id.full_name);
        this.first_name = findViewById(R.id.first_name);
        this.middle_name = findViewById(R.id.middle_name);
        this.last_name = findViewById(R.id.last_name);
        this.birthday = findViewById(R.id.birthday);
        this.sex = findViewById(R.id.sex);
        this.email = findViewById(R.id.email);
        this.mobile = findViewById(R.id.mobile);

        this.full_name.setText(full_name);
        this.first_name.setText(first_name);
        this.middle_name.setText(middle_name);
        this.last_name.setText(last_name);
        this.birthday.setText(birthday);
        this.sex.setText(sex);
        this.email.setText(email);
        this.mobile.setText(mobile);

    }
}
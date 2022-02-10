package com.example.konfidenciaapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FirstScreenActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        Bundle extras = getIntent().getExtras();
        String phone = extras.getString("phoneAfterCode");
        System.out.println(phone);



    }



}
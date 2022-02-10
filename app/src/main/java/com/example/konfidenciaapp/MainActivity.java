package com.example.konfidenciaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    private TextInputLayout enter_phone;
    private TextInputEditText editText;
    private Button get_code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        enter_phone = findViewById(R.id.textInputLayout);
        get_code = findViewById(R.id.get_code);
        editText = findViewById(R.id.textEditLayout);


        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = Objects.requireNonNull(enter_phone.getEditText()).getText().toString();
                if (phone.length() == 10) {
                    enter_phone.setErrorEnabled(false);
                }
            }
        });


        get_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = Objects.requireNonNull(enter_phone.getEditText()).getText().toString();
                if (phone.length() < 10) {
                    enter_phone.setError("Номер введен некоректно");
                    return;
                }
                String checkNine = phone.substring(0, 1);
                if (!checkNine.equals("9")) {
                    enter_phone.setError("Неправильно введено начало номера ");
                    return;
                }
                System.out.println(checkNine);
                Intent intent = new Intent(MainActivity.this, GetCodeActivity.class);
                intent.putExtra("phone", phone);
                startActivity(intent);
            }
        });


    }


}



package com.example.konfidenciaapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.konfidenciaapp.crm_1c.Client;
import com.example.konfidenciaapp.crm_1c.Parameters;
import com.example.konfidenciaapp.crm_1c.NewClient;
import com.example.konfidenciaapp.crm_1c.ParametersForPost;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddUserActivity extends AppCompatActivity {


    private static final String URL_FOR_POST = "http://84.204.149.203:8888/medicine_test/hs/konfidenciamobile/events/pacient/add/";
    private TextView phoneNumber;
    private EditText firstName;
    private EditText secondName;
    private EditText middleName;
    private Button button;

    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        phoneNumber = findViewById(R.id.phoneNumber);
        firstName = findViewById(R.id.firstName);
        secondName = findViewById(R.id.secondName);
//        middleName = findViewById(R.id.middleName);
        button = findViewById(R.id.login);


        Bundle extras = getIntent().getExtras();
        String mobile_phone = extras.getString("mobile_phone");

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.firstName, RegexTemplate.NOT_EMPTY,R.string.invalid_firstName);
        awesomeValidation.addValidation(this,R.id.secondName, RegexTemplate.NOT_EMPTY,R.string.invalid_secondName);
//        awesomeValidation.addValidation(this,R.id.middleName, RegexTemplate.NOT_EMPTY,R.string.invalid_middleName);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()){
                    createUser(mobile_phone);
                }

            }
        });
    }

    private void createUser(String mobile) {
        NewClient userForPost = new NewClient();


        String firstNameResult = firstName.getText().toString();
        String secondNameResult = secondName.getText().toString();
//        String middleNameResult = middleName.getText().toString();

        ParametersForPost parameters = new ParametersForPost();
        parameters.setFirst_name(firstNameResult);
//        parameters.setMiddle_name(middleNameResult);
        parameters.setLast_name(secondNameResult);
        parameters.setMobile(mobile);


        userForPost.setParameters(parameters);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_FOR_POST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        Call<NewClient> call = jsonPlaceHolderApi.addUser("as_konfidencia_mobile_app ",userForPost);

        call.enqueue(new Callback<NewClient>() {
            @Override
            public void onResponse(Call<NewClient> call, Response<NewClient> response) {
                if(response.isSuccessful()) {
                    System.out.println(response.message());
                    System.out.println(response.raw());
                    System.out.println(response.headers());
                    System.out.println(response.code());
                    System.out.println(response.toString());
                    System.out.println(response.body());
                    Intent intent = new Intent(AddUserActivity.this, PersonalAccountActivity.class);
                    intent.putExtra("first_name", firstNameResult);
                    intent.putExtra("middle_name", "");
                    intent.putExtra("last_name", secondNameResult);
                    intent.putExtra("mobile", mobile);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<NewClient> call, Throwable t) {
                System.out.println(t.toString());

            }
        });
    }
}
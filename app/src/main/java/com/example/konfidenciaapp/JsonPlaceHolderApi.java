package com.example.konfidenciaapp;


import com.example.konfidenciaapp.crm_1c.Client;
import com.example.konfidenciaapp.crm_1c.NewClient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("/medicine_test/hs/konfidenciamobile/events/pacient/info/{mobile}")
    Call<Client> getUser(@Header("apikey") String apikey, @Path("mobile") String mobile);

    @POST("/medicine_test/hs/konfidenciamobile/events/pacient/add/")
    Call<NewClient> addUser(@Header("apikey") String apikey, @Body NewClient userForPost);
}

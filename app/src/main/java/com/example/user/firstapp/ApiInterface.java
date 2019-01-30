package com.example.user.firstapp;

import com.example.user.firstapp.model.DefaultResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("service.php")
    Call<DefaultResponse> userRegistration(@Field("name") String name, @Field("username") String userName, @Field("password") String password, @Field("email") String email);

    @FormUrlEncoded
    @POST("login.php")
    Call<DefaultResponse> userLogin(@Field("username") String userName,@Field("password") String password);
}

package com.example.user.firstapp;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit {
    public static final String BASE_URL = "http://192.168.1.180/android1/Service/";

    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if( retrofit == null ){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}

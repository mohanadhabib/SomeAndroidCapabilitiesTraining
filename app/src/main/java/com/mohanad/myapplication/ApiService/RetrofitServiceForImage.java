package com.mohanad.myapplication.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceForImage {
    private static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("https://api.slingacademy.com/v1/sample-data/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}

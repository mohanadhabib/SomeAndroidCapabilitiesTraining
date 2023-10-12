package com.mohanad.myapplication.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
        private static Retrofit retrofit;
        public static Retrofit getRetrofit(){
            if(retrofit == null){
                retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
            }
            return retrofit;
        }
}

package com.example.fani.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    public static com.example.fani.API.ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jikan.moe/v3/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(com.example.fani.API.ApiService.class);
    }
}
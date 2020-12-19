package com.example.fani.API;

import com.example.fani.model.RootNarutoModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("anime?q=naruto")
    Call<RootNarutoModel> getData();
}
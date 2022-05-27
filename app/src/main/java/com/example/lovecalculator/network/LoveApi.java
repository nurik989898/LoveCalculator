package com.example.lovecalculator.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LoveApi {
@GET("getPercentage")
    Call<Model> loveCalculate(@Query("fname")String firstName,
                              @Query("sname")String secondName,
                                @Header("X-RapidAPI-Host")String host,
                                @Header("X-RapidAPI-Key")String key);
}

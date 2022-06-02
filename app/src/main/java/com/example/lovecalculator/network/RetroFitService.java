package com.example.lovecalculator.network;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitService {
    Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com").addConverterFactory(GsonConverterFactory.create())
            .build();

    public LoveApi getLoveApi(){
        return retrofit.create(LoveApi.class);
    }
}

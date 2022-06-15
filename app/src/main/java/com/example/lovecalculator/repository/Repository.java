package com.example.lovecalculator.repository;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.lovecalculator.R;
import com.example.lovecalculator.network.App;
import com.example.lovecalculator.network.LoveApi;
import com.example.lovecalculator.network.Model;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private  final  String HOST = "love-calculator.p.rapidapi.com";
    public static final String KEY = "0543a92391mshbc36b91471d70ddp16c854jsn1f8ee85720a4";
    LoveApi loveApi;
    @Inject
    public Repository(LoveApi loveApi1) {
        loveApi = loveApi1;
    }

    public MutableLiveData<Model>getData(String first, String second){
        MutableLiveData<Model>localMutableLiveData = new MutableLiveData<>();
        loveApi.loveCalculate(first,second,HOST,KEY).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful()){
                    localMutableLiveData.postValue(response.body());


                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e("ololo", "onFailure:"+ t.getMessage());
            }
        });
        return localMutableLiveData;
    }
}

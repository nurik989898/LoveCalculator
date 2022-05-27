package com.example.lovecalculator.network;

import android.app.Application;

public class App extends Application {
    public static LoveApi api;
    @Override
    public void onCreate() {
        super.onCreate();
        RetroFitService retroFitService = new RetroFitService();
        api = retroFitService.getLoveApi();
    }
}

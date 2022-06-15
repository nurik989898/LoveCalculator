package com.example.lovecalculator;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private SharedPreferences preferences;
    public void saveBoardState(){
        preferences.edit().putBoolean("isBoardShown",true).apply();
    }
    public boolean isBoardShown(){
        return preferences.getBoolean("isBoardShown",false);
    }
    public void setCon(Context context){
        preferences = context.getSharedPreferences("settings",Context.MODE_PRIVATE);
    }

}

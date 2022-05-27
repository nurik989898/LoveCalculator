package com.example.lovecalculator.network;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("fname")
    public String firstName;
    @SerializedName("sname")
    public String secondName;
    public String percentage;
    public String result;
}

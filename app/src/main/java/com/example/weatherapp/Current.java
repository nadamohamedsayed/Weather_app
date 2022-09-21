package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class Current {

    @SerializedName("temp_c")
    private String temp_c;

    @SerializedName("temp_f")
    private String temp_f;

    public String getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(String temp_c) {
        this.temp_c = temp_c;
    }

    public String getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(String temp_f) {
        this.temp_f = temp_f;
    }
}

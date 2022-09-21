package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class data {

    @SerializedName("current")
    private Current current;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}




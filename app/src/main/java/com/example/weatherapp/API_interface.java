package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API_interface {


   /* @GET("v1/current.json?key=ff9f895b2e884d6680530135202710&q=Kuala%20Lumpur")
    public Call<data> getresult();
*/
    @GET("v1/current.json?key=ff9f895b2e884d6680530135202710")
    public Call<data> getresult(@Query("q") String cityname);



}

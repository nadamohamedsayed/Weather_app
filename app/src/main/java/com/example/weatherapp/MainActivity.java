package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    public Button btn;
   // public EditText edt1,edt2;
    Spinner spinner;
    public Retrofit retrofit;
    //public String url="http://api.weatherapi.com/v1/current.json?key=ff9f895b2e884d6680530135202710&q={city name}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        spinner = (Spinner) findViewById(R.id.spin);

        ArrayAdapter<String> myadapter= new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.cities));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.weatherapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API_interface api_interface1 = retrofit.create(API_interface.class);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String item = spinner.getSelectedItem().toString();

                Call<data> call = api_interface1.getresult(item);
                call.enqueue(new Callback<data>() {
                    @Override
                    public void onResponse(Call<data> call, Response<data> response) {

                        Intent intent = new Intent(MainActivity.this,Home.class);
                        intent.putExtra("c",response.body().getCurrent().getTemp_c());
                        intent.putExtra("f",response.body().getCurrent().getTemp_f());
                        startActivity(intent);
                        //Toast.makeText(MainActivity.this,item, Toast.LENGTH_SHORT).show();

                       // edt1.setText(response.body().getCurrent().getTemp_c());
                        // edt2.setText(response.body().getCurrent().getTemp_f());
                    }

                    @Override
                    public void onFailure(Call<data> call, Throwable t) {

                        Toast.makeText(MainActivity.this,"something happend", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }


}
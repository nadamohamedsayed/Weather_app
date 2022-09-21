package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    public EditText edt1,edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

        String clecuis = getIntent().getStringExtra("c");
        String feh = getIntent().getStringExtra("f");

        edt1.setText(clecuis);
        edt2.setText(feh);
    }
}
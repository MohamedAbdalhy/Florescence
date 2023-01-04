package com.example.hay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PreCompany extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_company);
    }

    public void createMeet(View view) {
        Intent i =  new Intent(this,Formmeet.class);
        startActivity(i);
    }
}
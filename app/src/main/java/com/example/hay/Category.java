package com.example.hay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }

    public void weddingCat(View view) {
        Intent towed = new Intent(this,CompanysList.class);
        startActivity(towed);
    }

    public void socialCat(View view) {
        Intent to = new Intent(this,Formmeet.class);
       startActivity(to);
    }
}
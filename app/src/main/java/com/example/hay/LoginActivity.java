package com.example.hay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            }

    public void signup(View view) {
        Intent  reg = new Intent(this,RegisterActivity.class);
        startActivity(reg);

    }

    public void tobook(View view) {
        Intent  book = new Intent(this,Category.class);
        startActivity(book);
        finish();
    }
}
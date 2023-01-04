package com.example.hay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class CompanysList extends AppCompatActivity implements CustomAdepter.OnCompanyPre {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_companyslist);
        ArrayList<CompanyCard> companys =new ArrayList<>();

        companys.add(new CompanyCard("company 1",R.drawable.comp,"50000","20000"));
        companys.add(new CompanyCard("company 2",R.drawable.comp,"50000","20000"));
        companys.add(new CompanyCard("company 3",R.drawable.comp,"50000","20000"));
        companys.add(new CompanyCard("company 4",R.drawable.comp,"50000","20000"));
        companys.add(new CompanyCard("company 5",R.drawable.comp,"50000","20000"));
        companys.add(new CompanyCard("company 6",R.drawable.comp,"50000","20000"));
        companys.add(new CompanyCard("company 7",R.drawable.comp,"50000","20000"));
        companys.add(new CompanyCard("company 8",R.drawable.comp,"50000","20000"));
        companys.add(new CompanyCard("company 9",R.drawable.comp,"50000","20000"));
        companys.add(new CompanyCard("company 10",R.drawable.comp,"50000","20000"));
        companys.add(new CompanyCard("company 11",R.drawable.comp,"50000","20000"));


        CustomAdepter adepter = new CustomAdepter(this,companys);
        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
                rv.setLayoutManager(manager);
        rv.setAdapter(adepter);



    }

    @Override
    public void OnCompanyClick(int position) {
        Intent i = new Intent(this,PreCompany.class);
        startActivity(i);
    }
}
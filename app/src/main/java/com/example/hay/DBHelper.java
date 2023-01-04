package com.example.hay;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context,"MeetList",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table MeetingList (_id INTEGER primary key autoincrement , " +
        "Company_name text ," +
        " Rescheduled text," +
        "Attendnum TEXT," +
        "package text," +
        "AvaliableTime text," +
        "Comment text ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

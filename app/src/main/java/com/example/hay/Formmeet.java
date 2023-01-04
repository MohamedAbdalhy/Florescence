package com.example.hay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Formmeet<id> extends AppCompatActivity {
    private EditText CompanyName;
    private EditText Rescheduled;
    private EditText AttendanceNumber;
    private EditText packageType;
    private EditText appointments;
    private EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formmeet);
        CompanyName = findViewById(R.id.etCompany);
        Rescheduled = findViewById(R.id.etRescheduled);
        AttendanceNumber = findViewById(R.id.attendancenum);
        packageType = findViewById(R.id.etpackage);
        appointments = findViewById(R.id.avilabletime);
        comment = findViewById(R.id.etComment);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_meeting, menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_save_meeting) {
            savemeet();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void savemeet() {
        String writtenCompany = CompanyName.getText().toString();
        String writtenAttendanceNumber = AttendanceNumber.getText().toString();
        String writtenRescheduled = Rescheduled.getText().toString();
        String writtenpackageType = packageType.getText().toString();
        String writtenappointments = appointments.getText().toString();
        String writtencomment = comment.getText().toString();

        if (writtenCompany.isEmpty() || writtenAttendanceNumber.isEmpty()||writtenRescheduled.isEmpty()||writtenpackageType.isEmpty()|| writtenappointments.isEmpty()) {
            CompanyName.setError(getString(R.string.required_field));
            AttendanceNumber.setError(getString(R.string.required_field));
            Rescheduled.setError(getString(R.string.required_field));
            packageType .setError(getString(R.string.required_field));
            appointments.setError(getString(R.string.required_field));}

        else{

                ContentValues values = new ContentValues();
                values.put("Company_name", writtenCompany);
                values.put("Rescheduled", writtenRescheduled);
                values.put("package", writtenpackageType);
                values.put("Attendnum", writtenAttendanceNumber);
                values.put("Comment", writtencomment);
                values.put("AvaliableTime", writtenappointments);


                DBHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();
                long id = db.insert("MeetingList", null, values);
                if (id != 1) {
                    Toast.makeText(this, "Meeting Not Saved", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }





    public void tomain(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}


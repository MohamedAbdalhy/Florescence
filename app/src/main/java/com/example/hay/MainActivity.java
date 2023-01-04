package com.example.hay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MeetModel> meets = new ArrayList<>();
    private MeetingAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("All Meeting");
    }

    @Override
    protected void onResume() {
        super.onResume();
        getMeetings();
    }

    public void tomeet(View view) {
        Intent i = new Intent(this, Formmeet.class);
        startActivity(i);
    }

    private void getMeetings() {
        meets.clear();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * FROM MeetingList ", null);
        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String CompanyName = cursor.getString(1);
            String resch = cursor.getString(2);
            String auttNum = cursor.getString(3);
            String packedge = cursor.getString(4);
            String avtime = cursor.getString(5);
            String comment = cursor.getString(6);
            meets.add(new MeetModel(id, CompanyName, packedge, resch, auttNum, avtime, comment));

        }
        showMeets();
    }

    private void showMeets() {
        View view = findViewById(R.id.layout_no_note);
        if (meets.size() == 0)
            view.setVisibility(View.VISIBLE);
        else {
            view.setVisibility(View.INVISIBLE);
            adapter = new MeetingAdapter(this, meets);
            recyclerView = findViewById(R.id.recycler_meeting);
            recyclerView.setAdapter(adapter);
            swipeToDelete();
        }

    }

    private void swipeToDelete() {

        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
deleteDialog(position);
            }
        };
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    private void deleteFromDtatbase(int position) {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] args = {(String.valueOf(meets.get(position).getId()))};
        int deletedRows = db.delete("MeetingList", "_id==?", args);
        if (deletedRows != 0)
            Toast.makeText(this, "meeting cancled", Toast.LENGTH_SHORT).show();

    }
    private void deleteDialog  (int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Are you sure about the cancellation Meeting ? ")
                 .setMessage("Cancellation may cost you a fine of up to 100 Egyptian pounds")
                .setPositiveButton("OK", (dialog, which) -> {
                    deleteFromDtatbase(position);
                    meets.remove(position);
                    adapter.notifyDataSetChanged();
                    if (meets.size()==0) {
                        View view = findViewById(R.id.layout_no_note);
                        view.setVisibility(View.VISIBLE);
                    }
                })
                .setNegativeButton("cancel", (dialog, which) -> {
                    adapter.notifyItemChanged(position);

                })
                .setCancelable(false)
                .show();

    }
}
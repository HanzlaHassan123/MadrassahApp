package com.example.mudrassahapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mudrassahapp.DBHandler;
import com.example.mudrassahapp.R;
import com.example.mudrassahapp.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchResult extends AppCompatActivity {
    RecycleViewAdapter customAdapter;

    RecyclerView recyclerView;
    List<String> rollNo,name,age,Class,sabaq,sabaqi,manzil,date;
    DBHandler dbHelper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);

        dbHelper = new DBHandler(SearchResult.this);

        rollNo = new ArrayList<>();
        name = new ArrayList<>();
        age = new ArrayList<>();
        Class = new ArrayList<>();
        sabaq = new ArrayList<>();
        sabaqi = new ArrayList<>();
        manzil = new ArrayList<>();
        date = new ArrayList<>();

        Intent intent = getIntent();
        String rollNum = intent.getStringExtra("RollNo");
        displayStudentRecords(rollNum);
        customAdapter = new RecycleViewAdapter(rollNo,name,age,Class,sabaq,sabaqi,manzil);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchResult.this));
    }
    void displayStudentRecords(String rollNum){
        Cursor cursor = dbHelper.getStudentAndTaskRecords(rollNum);

        if (cursor.getCount()==0){
            Toast.makeText(this,"No record Found",Toast.LENGTH_SHORT).show();
        }
        else {
            while(cursor.moveToNext()){
                rollNo.add(cursor.getString(0));
                name.add(cursor.getString(1));
                age.add(cursor.getString(2));
                Class.add(cursor.getString(3));
                sabaq.add(cursor.getString(5));
                sabaqi.add(cursor.getString(6));
                manzil.add(cursor.getString(7));
                date.add(cursor.getString(8));
            }
        }
    }
}
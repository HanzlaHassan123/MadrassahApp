package com.example.mudrassahapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
  private Button searchButton;
  RecycleViewAdapter recycleViewAdapter;
  List<String> Rollno,Name,Age,classRoom,Sabaq,Sabaqi,Manzil,date;
  public DBHandler dbHandler;
  private EditText editTextRollNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchButton=findViewById(R.id.Searching);
        editTextRollNo=findViewById(R.id.editTextText);

        dbHandler=new DBHandler(Search.this);
        Rollno=new ArrayList<>();
        Name=new ArrayList<>();
        Age=new ArrayList<>();
        classRoom=new ArrayList<>();
        Sabaq=new ArrayList<>();
        Sabaqi=new ArrayList<>();
        Manzil=new ArrayList<>();
        date=new ArrayList<>();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollNo=editTextRollNo.getText().toString();
                displayStudentRecords(rollNo);
                recycleViewAdapter=new RecycleViewAdapter(Rollno,Name,Age,classRoom,Sabaq,Sabaqi,Manzil);
            }
        });


    }

    void displayStudentRecords(String rollNo){
        Cursor cursor = dbHandler.getStudentAndTaskRecords(rollNo);
        if (cursor.getCount()==0){
            Toast.makeText(this,"No record Found", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {
                Rollno.add(cursor.getString(0));
                Name.add(cursor.getString(1));
                Age.add(cursor.getString(2));
                classRoom.add(cursor.getString(3));
                Sabaq.add(cursor.getString(5));
                Sabaqi.add(cursor.getString(6));
                Manzil.add(cursor.getString(7));
                date.add(cursor.getString(8));
            }
        }
    }
}
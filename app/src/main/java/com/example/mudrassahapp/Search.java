package com.example.mudrassahapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.mudrassahapp.R;



public class Search extends AppCompatActivity {

    private Button searchButton;
    private EditText editTextRollno;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchButton = findViewById(R.id.Searching);
        editTextRollno = findViewById(R.id.editTextText);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rollNum = editTextRollno.getText().toString();
                Intent intent =new Intent(Search.this, SearchResult.class);
               intent.putExtra("RollNo",rollNum);
                startActivity(intent);
            }
        });
    }
}
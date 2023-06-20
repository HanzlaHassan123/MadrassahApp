package com.example.mudrassahapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,StudentDetails.class);
                startActivity(intent);
            }
        });


    }

    public void ClickDailyTask(View v){
        Intent intent=new Intent(MainActivity.this, DailyTask.class);
        startActivity(intent);
    }

    public void ClickSearch(View v){
        Intent intent=new Intent(MainActivity.this, Search.class);
        startActivity(intent);
    }
}
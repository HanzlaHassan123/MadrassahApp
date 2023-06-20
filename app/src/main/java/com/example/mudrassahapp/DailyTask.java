package com.example.mudrassahapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DailyTask extends AppCompatActivity {
    EditText RollnoET,SabaqET,SabaqiET,ManzilET;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_task);

        RollnoET=findViewById(R.id.RollNo2);
        SabaqET=findViewById(R.id.Sabaq);
        SabaqiET=findViewById(R.id.Sabaqi);
        ManzilET=findViewById(R.id.Manzil);

        btn=findViewById(R.id.button5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Rollno= RollnoET.getText().toString();
                String Sabaq= SabaqET.getText().toString();
                String Sabaqi= SabaqiET.getText().toString();
                String Manzil= ManzilET.getText().toString();

                TaskRecords taskRecords=new TaskRecords(Rollno,Sabaq,Sabaqi,Manzil);
                DBHandler dbHandler= new DBHandler(DailyTask.this);
                dbHandler.addTaskRecords(taskRecords);

                Toast.makeText(DailyTask.this, "Task record is inserted ", Toast.LENGTH_SHORT).show();
                finish();

            }
        });



    }
}
package com.example.mudrassahapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentDetails extends AppCompatActivity {
   EditText rollno,name,age,Class;
   Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);


        rollno=findViewById(R.id.Rollno);
        name=findViewById(R.id.Name);
        age=findViewById(R.id.Age);
        Class=findViewById(R.id.Class);

        btn=findViewById(R.id.saveStudentDetails);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollNo=rollno.getText().toString();
                String Name=name.getText().toString();
                String Age=age.getText().toString();
                String ClassRoom=Class.getText().toString();

                Student student =new Student(rollNo,Name,Age,ClassRoom);

                DBHandler dbHandler=new DBHandler(StudentDetails.this);
                dbHandler.addStudent(student);

                Toast.makeText(StudentDetails.this, "student details save succesfully ", Toast.LENGTH_SHORT).show();

                finish();

            }
        });


    }
}
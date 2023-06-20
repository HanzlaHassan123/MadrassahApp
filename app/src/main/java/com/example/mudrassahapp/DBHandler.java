package com.example.mudrassahapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DataBaseName="madrassh.db";
    private  static final  String TABLE_STUDENT="students";
    private static final String TABLE_TASK_RECORDS="taskrecord";

    private static final String COLUMN_ROLLNO="rollNo";

    // student records

    private static final String COLUMN_NAME="name";
    private static final String COLUMN_AGE="age";
    private static final String COLUMN_CLASS="class";

// task records
    private static final String COLUMN_SABAQ="sabaq";
    private static final String COLUMN_SABAQI="sabaqi";
    private static final String COLUMN_MANZIL="manzil";
    private static final String COLUMN_DATE="date";


    private static final String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_STUDENT + "("
            + COLUMN_ROLLNO + " TEXT Primary Key, "
            + COLUMN_NAME + " TEXT, "
            + COLUMN_AGE + " TEXT, "
            + COLUMN_CLASS + " TEXT"
            + ")";


    private static final String CREATE_TASK_RECORDS_TABLE = "CREATE TABLE " + TABLE_TASK_RECORDS + "("
            + COLUMN_ROLLNO + " TEXT Primary Key, "
            + COLUMN_SABAQ + " TEXT, "
            + COLUMN_SABAQI + " TEXT, "
            + COLUMN_MANZIL + " TEXT, "
            + COLUMN_DATE + " TEXT, "
            + "FOREIGN KEY(" + COLUMN_ROLLNO + ") REFERENCES " + TABLE_STUDENT + "(" + COLUMN_ROLLNO + ")"
            + ")";




    @Override
    public void onCreate(SQLiteDatabase DB) {
        //CREATE TABLE
        DB.execSQL(CREATE_STUDENT_TABLE);
        DB.execSQL(CREATE_TASK_RECORDS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int olderversion, int newversion) {
    DB.execSQL("DROP TABLE IF EXISTS "+ TABLE_TASK_RECORDS);
        DB.execSQL("DROP TABLE IF EXISTS "+ TABLE_STUDENT);
  // CREATE TABLE
        onCreate(DB);
    }
    public DBHandler(Context context){
        super(context,DataBaseName,null,1);

    }

    public void addStudent(Student student){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COLUMN_ROLLNO,student.getRollNo());
        values.put(COLUMN_NAME,student.getName());
        values.put(COLUMN_AGE,student.getAge());
        values.put(COLUMN_CLASS,student.getClassName());
        // creating table of student and then adding values of each column
        db.insert(TABLE_STUDENT,null,values);
        db.close();

    }

    public void addTaskRecords(TaskRecords records){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COLUMN_ROLLNO,records.getRollNo());
        values.put(COLUMN_SABAQ,records.getSabaq());
        values.put(COLUMN_SABAQI,records.getSabaqi());
        values.put(COLUMN_MANZIL,records.getManzil());

        db.insert(TABLE_TASK_RECORDS,null,values);
        db.close();

    }

}

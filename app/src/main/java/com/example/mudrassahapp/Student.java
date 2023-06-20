package com.example.mudrassahapp;

import androidx.annotation.NonNull;

public class Student {
    private String RollNo;
    private String Name;
    private String age;
    private String ClassName;

    public Student(String rollNo, String name, String age, String aClass) {
        RollNo = rollNo;
        Name = name;
        this.age = age;
        ClassName = aClass;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }
}

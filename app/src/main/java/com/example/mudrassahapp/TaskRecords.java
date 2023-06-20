package com.example.mudrassahapp;

public class TaskRecords {
    private String RollNo;
    private String Sabaq;
    private String Sabaqi;
    private String Manzil;

    public TaskRecords(String rollNo, String sabaq, String sabaqi, String manzil) {
        RollNo = rollNo;
        Sabaq = sabaq;
        Sabaqi = sabaqi;
        Manzil = manzil;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getSabaq() {
        return Sabaq;
    }

    public void setSabaq(String sabaq) {
        Sabaq = sabaq;
    }

    public String getSabaqi() {
        return Sabaqi;
    }

    public void setSabaqi(String sabaqi) {
        Sabaqi = sabaqi;
    }

    public String getManzil() {
        return Manzil;
    }

    public void setManzil(String manzil) {
        Manzil = manzil;
    }
}

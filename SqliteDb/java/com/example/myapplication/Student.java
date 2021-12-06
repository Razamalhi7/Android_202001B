package com.example.myapplication;

import android.graphics.Bitmap;

public class Student {

    public  String Id;
    public String Name;
    public String Phone;
    public String Email;
    public String Password;
    public Bitmap Img;
    public Student(String id,String name, String phone, String email, String password,Bitmap img) {
        Id=id;
        Name = name;
        Phone = phone;
        Email = email;
        Password = password;
        Img=img;
    }
}

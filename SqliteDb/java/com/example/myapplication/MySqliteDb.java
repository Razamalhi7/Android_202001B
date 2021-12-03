package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqliteDb extends SQLiteOpenHelper {
    public MySqliteDb(Context context) {
        super(context, "StudentDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Student(Id INTEGER primary key autoincrement,Name text,Phone text,Email text,Password text,Image blob )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertStudent(String name, String phone, String email, String password,byte[] Image)
    {
        SQLiteDatabase db=  getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Name",name);
        values.put("Phone",phone);
        values.put("Email",email);
        values.put("Password",password);
        values.put("Image",Image);

        long res=  db.insert("Student",null,values);
        return  res!=-1;
    }

    public Cursor getStudents()
    {
       SQLiteDatabase db=  getWritableDatabase();
       Cursor cursor= db.rawQuery("select * from  Student ",null);
       return  cursor;
    }
    public Cursor getStudents(String search)
    {
        SQLiteDatabase db=  getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from  Student where Name like '%"+search+"%' or Phone like '%"+search+"%' or Email like '%"+search+"%'",null);
        return  cursor;
    }
    public Cursor getStudent(String id)
    {
        SQLiteDatabase db=  getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from  Student where Id="+id,null);
        return  cursor;
    }

    public boolean updateStudent(String Id,String name, String phone, String email, String password,byte[] Image)
    {
        SQLiteDatabase db=  getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Name",name);
        values.put("Phone",phone);
        values.put("Email",email);
        values.put("Password",password);
        if(Image!=null)
            values.put("Image",Image);
        int res=  db.update("Student",values,"Id=?",new String[]{Id});
        return  res>0;
    }

    public boolean deleteStudent(String Id)
    {
        SQLiteDatabase db=  getWritableDatabase();
        int res=  db.delete("Student","Id=?",new String[]{Id});
        return  res>0;
    }


}

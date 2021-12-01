package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText txtName,txtPhone,txtEmail,txtPassword;
    ImageView imageView;

    MySqliteDb db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName=findViewById(R.id.txtName);
        txtPhone=findViewById(R.id.txtPhone);
        txtEmail=findViewById(R.id.txtEmail);
        txtPassword=findViewById(R.id.txtPassword);

        imageView=findViewById(R.id.img);
        db=new MySqliteDb(this);

    }

    public void btn_submit(View view)
    {
        String name=txtName.getText().toString();
        String phone=txtPhone.getText().toString();
        String email=txtEmail.getText().toString();
        String pass=txtPassword.getText().toString();
        boolean isInserted=db.insertStudent(name,phone,email,pass);
        if(isInserted)
        {
            Toast.makeText(this, "insert successfully...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Error : record not saved.", Toast.LENGTH_SHORT).show();
        }

    }

    public void btn_view_data(View view)
    {
        String str="";
        Cursor cursor=db.getStudents();
        while (cursor.moveToNext())
        {
            str+=cursor.getString(0)+"\n";
            str+=cursor.getString(1)+"\n";
            str+=cursor.getString(2)+"\n";
            str+=cursor.getString(3)+"\n";
            str+=cursor.getString(4)+"\n\n";
        }

        new AlertDialog.Builder(this)
                .setMessage(str)
                .create()
                .show();

    }
}
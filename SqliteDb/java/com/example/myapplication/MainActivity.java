package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {


    EditText txtName,txtPhone,txtEmail,txtPassword;
    ImageView imageView;
    Uri  uri=null;
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
    {if(uri!=null)
    {
        


    }



        String name=txtName.getText().toString();
        String phone=txtPhone.getText().toString();
        String email=txtEmail.getText().toString();
        String pass=txtPassword.getText().toString();
        boolean isInserted=db.insertStudent(name,phone,email,pass,null);
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

    public void btn_intent_students(View view)
    {
        Intent intent=new Intent(this,Students.class);
        startActivity(intent);
    }

    public void btn_browse_img(View view)
    {
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        startActivityForResult(intent,101);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK && requestCode==101)
        {
            uri=data.getData();
            imageView.setImageURI(uri);
        }

    }
}





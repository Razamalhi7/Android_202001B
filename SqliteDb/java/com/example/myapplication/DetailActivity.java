package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    MySqliteDb db;
    CircleImageView circleImageView;
    TextView txtName,txtEmail,txtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        circleImageView=findViewById(R.id.std_img_detail);
        txtName=findViewById(R.id.std_name_detail);
        txtPhone=findViewById(R.id.std_phone_detail);
        txtEmail=findViewById(R.id.std_email_detail);


        db=new MySqliteDb(this);
        Bundle bundle= getIntent().getExtras();
        String id=bundle.getString("StudentId");
        Cursor cursor=db.getStudent(id);
        if (cursor.moveToNext())
        {
            String name=cursor.getString(1);
            String phone=cursor.getString(2);
            String email=cursor.getString(3);
            String password=cursor.getString(4);
            byte[] imgArr= cursor.getBlob(5);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imgArr, 0, imgArr.length);

            circleImageView.setImageBitmap(bitmap);
            txtName.setText(name);
            txtPhone.setText(phone);
            txtEmail.setText(email);

        }

    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditActivity extends AppCompatActivity {

    EditText txtName,txtPhone,txtEmail,txtPassword;
    CircleImageView circleImageView;
    Uri uri=null;
    MySqliteDb db;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        txtName=findViewById(R.id.edit_txtName);
        txtPhone=findViewById(R.id.edit_txtPhone);
        txtEmail=findViewById(R.id.edit_txtEmail);
        txtPassword=findViewById(R.id.edit_txtPassword);

        circleImageView=findViewById(R.id.edit_img);
        db=new MySqliteDb(this);
        Bundle bundle= getIntent().getExtras();
        id=bundle.getString("StudentId");
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
            txtPassword.setText(password);
        }

    }
    public void btn_update(View view)
    {
        byte[] inputData=null;
        if(uri!=null)
        {
            InputStream iStream = null;
            try {
                iStream = getContentResolver().openInputStream(uri);
                inputData = getBytes(iStream);

            } catch (Exception e) {
                inputData=null;
                Toast.makeText(this, "Image cannot convert to byte array", Toast.LENGTH_SHORT).show();
            }
        }

        String name=txtName.getText().toString();
        String phone=txtPhone.getText().toString();
        String email=txtEmail.getText().toString();
        String pass=txtPassword.getText().toString();
        boolean isUpdated=db.updateStudent(id,name,phone,email,pass,inputData);
        if(isUpdated)
        {
            Toast.makeText(this, "Update successfully...", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,Students.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Error : record not saved.", Toast.LENGTH_SHORT).show();
        }

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
            circleImageView.setImageURI(uri);
        }

    }

    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }
}
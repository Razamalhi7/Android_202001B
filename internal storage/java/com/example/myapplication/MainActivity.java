package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText txtwrite,txtRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtwrite=findViewById(R.id.txtWrite);
        txtRead=findViewById(R.id.txtRead);
    }
    public void write(View view)
    {
        try {
            FileOutputStream fileOutputStream=openFileOutput("abc.txt",MODE_PRIVATE);
            fileOutputStream.write(txtwrite.getText().toString().getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(this, "write Successfully in "+getDataDir().getAbsolutePath(), Toast.LENGTH_LONG).show();
        }catch(Exception exe)
        {
            Toast.makeText(this, exe.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void read(View view)
    {
        try {
            FileInputStream inputStream=openFileInput("abc.txt");
            String str="";
            int a;
            while((a=inputStream.read())!=-1)
            {
                str+=(char)a;
            }
            txtRead.setText(str);
            Toast.makeText(this, "write Successfully", Toast.LENGTH_LONG).show();
        }catch(Exception exe)
        {
            Toast.makeText(this, exe.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}

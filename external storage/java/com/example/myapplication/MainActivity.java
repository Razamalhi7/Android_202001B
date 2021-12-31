package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
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
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},101);
        }
        else
        {
            try {
                String state= Environment.getExternalStorageState();
                if(Environment.MEDIA_MOUNTED.equals(state))
                {
                    File root=Environment.getExternalStorageDirectory();
                    File dir=new File(root,"MyFolder");
                    if(!dir.exists())
                    {
                        dir.mkdir();
                    }
                    File file=new File(dir,"MyFile.txt");
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(txtwrite.getText().toString().getBytes());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    Toast.makeText(this, "write Successfully in "+getDataDir().getAbsolutePath(), Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this, "SD card not found", Toast.LENGTH_SHORT).show();
                }
            }catch(Exception exe)
            {
                Toast.makeText(this, exe.getMessage(), Toast.LENGTH_LONG).show();
                new AlertDialog.Builder(this).setMessage(exe.getMessage()).create().show();
            }
        }
    }
    public void read(View view)
    {
        try {
            String state= Environment.getExternalStorageState();
            if(Environment.MEDIA_MOUNTED.equals(state))
            {
                File root=Environment.getExternalStorageDirectory();
                File dir=new File(root,"MyFolder");
                File file=new File(dir,"MyFile.txt");
                FileInputStream inputStream=new FileInputStream(file);
                String str="";
                int a;
                while((a=inputStream.read())!=-1)
                {
                    str+=(char)a;
                }
                txtRead.setText(str);
            }
            else
            {
                Toast.makeText(this, "SD card not found", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "write Successfully", Toast.LENGTH_LONG).show();
        }catch(Exception exe)
        {
            Toast.makeText(this, exe.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText txtname,txtPassword,txtEmail,txtTime,txtDate;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtname=findViewById(R.id.txtName);
        txtPassword=findViewById(R.id.txtPassword);
        txtEmail=findViewById(R.id.txtEmail);
        txtTime=findViewById(R.id.txtTime);
        txtDate=findViewById(R.id.txtDate);
        txt=findViewById(R.id.textView);


    }

    public void btn_click(View view)
    {
        String name=txtname.getText().toString();
        String pass=txtPassword.getText().toString();
        String email=txtEmail.getText().toString();
        String time=txtTime.getText().toString();
        String date=txtDate.getText().toString();


        String str=name+"\n"+pass+"\n"+email+"\n"+time+"\n"+date;

        txt.setText(str);

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
























package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ComponentActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SmsManager smsManager;
    EditText txtSms,txtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSms=findViewById(R.id.txtMsg);
        txtNumber=findViewById(R.id.txtNumber);


        smsManager=SmsManager.getDefault();

    }

    public void btn_send_sms(View view)
    {

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_GRANTED)
        {
            String number=txtNumber.getText().toString();
            String sms=txtSms.getText().toString();
            smsManager.sendTextMessage(number,null,sms,null,null);
            Toast.makeText(this, "Sms Sent..", Toast.LENGTH_SHORT).show();

        }
        else
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},100);
        }


    }


}
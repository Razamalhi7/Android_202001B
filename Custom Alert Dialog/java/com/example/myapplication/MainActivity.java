package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_custom_alert_dialog(View view)
    {

        LayoutInflater layoutInflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View   v =layoutInflater.inflate(R.layout.custom_dialog_layout,null);

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setView(v);

        AlertDialog alertDialog=builder.create();
        alertDialog.show();


        ImageView btn_close=v.findViewById(R.id.img_btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        ImageView btn_download=v.findViewById(R.id.img_btn_download);
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.tencent.ig&hl=en&gl=US"));
                startActivity(intent);
            }
        });




    }
}
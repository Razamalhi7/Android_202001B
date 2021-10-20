package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void btn_alert_dialog(View view)
    {

       AlertDialog.Builder builder=new AlertDialog.Builder(this);
       builder.setTitle("Alert..");
       builder.setMessage("Are you sure do you want to delete this record?");
       builder.setIcon(R.drawable.ic_baseline_delete_24);
       builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               Toast.makeText(MainActivity.this, "Canceled by user.", Toast.LENGTH_SHORT).show();
           }
       });
       builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

               Toast.makeText(MainActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
           }
       });
       AlertDialog alertDialog=builder.create();
       alertDialog.show();

    }

    public void btn_alert_dialog_ring(View view)
    {
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Downloading...");
        progressDialog.setMessage("Please wait until downloading completed.");
        progressDialog.setIcon(R.drawable.ic_download);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        progressDialog.show();
    }
    int i;
    public void alert_dialog_horizontal(View view)
    {

        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Downloading...");
        progressDialog.setMessage("Please wait until downloading completed.");
        progressDialog.setIcon(R.drawable.ic_download);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        progressDialog.show();



        Handler  handler = new Handler();
        i=1;
        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                progressDialog.setProgress(i++);
                if(i<=100)
                {
                    handler.postDelayed(this,200);
                }
                else {
                    progressDialog.dismiss();
                }

            }
        };
        handler.postDelayed(runnable,100);


    }
}
























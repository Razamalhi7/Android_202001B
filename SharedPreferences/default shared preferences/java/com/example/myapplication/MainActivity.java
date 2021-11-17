package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);


    }

    public void btn_setting(View view)
    {
        Intent intent=new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }

    public void btn_get(View view)
    {
        String username=sharedPreferences.getString("UserName","not found");
        String Password=sharedPreferences.getString("Password","not found");
        String Gender=sharedPreferences.getString("Gender","Male");

        String subjects="";
       Set<String> lstSubjects= sharedPreferences.getStringSet("Subjects",null);
       for(String sub:lstSubjects)
       {
           subjects+=sub+"\n";
       }

        new AlertDialog.Builder(this)
                .setMessage(username+"\n"+Password+"\n"+Gender+"\n\n"+subjects)
                .create().show();
    }
}
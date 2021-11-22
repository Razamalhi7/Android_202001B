package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public  static ArrayList<String> lst=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    }

    public void btn_fetch(View view)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new ListFragment(this)).commit();
    }

    public void btn_save(View view)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new InsertFragment(this)).commit();
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {


    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        viewFlipper=findViewById(R.id.viewFlipper);

        viewFlipper.setFlipInterval(3000);


    }

    public void btn_pre(View view)
    {
        viewFlipper.showPrevious();
    }

    public void btn_play(View view)
    {
        viewFlipper.startFlipping();
    }

    public void btn_stop(View view)
    {
        viewFlipper.stopFlipping();
    }

    public void btn_next(View view)
    {
        viewFlipper.showNext();
    }

}
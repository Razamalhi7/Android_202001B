package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ChipGroup chipGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.txtTag);
        chipGroup=findViewById(R.id.chipGroup);


    }

    public void btn_add_chip(View view)
    {
        String tag=editText.getText().toString();
        Chip chip=new Chip(this);
        chip.setText(tag);
        chip.setCheckable(true);
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chipGroup.removeView(chip);
            }
        });

        chipGroup.addView(chip);
    }

    public void btn_select_tags(View view)
    {
       ArrayList<View> chips=  chipGroup.getTouchables();
        String str="";
        for(View v:chips)
        {
            Chip chip=(Chip)v;
            if(chip.isChecked())
                str+=chip.getText().toString()+"\n";

        }
        new AlertDialog.Builder(this).setMessage(str).create().show();
    }
}








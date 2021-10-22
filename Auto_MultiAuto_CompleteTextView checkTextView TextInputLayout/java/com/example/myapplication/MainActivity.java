package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckedTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        ArrayList<String> Names=new ArrayList<>();
        Names.add("Hashir Nabi");
        Names.add("Waqqar Raza");
        Names.add("Baran Naseer");
        Names.add("Faraz Ali");
        Names.add("Sheraz Ali");
        Names.add("Anosha Rasheed");
        Names.add("Abdullah Al Banaja");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Names);

        autoCompleteTextView.setAdapter(adapter);


        multiAutoCompleteTextView=findViewById(R.id.multiAutoCompleteTextView);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());





    }

    public void click_check_textview(View view)
    {

        CheckedTextView checkedTextView= (CheckedTextView) view;
        if(checkedTextView.isChecked())
        {
            checkedTextView.setCheckMarkDrawable(R.drawable.ic_baseline_close_24);
            checkedTextView.setChecked(false);
            Toast.makeText(this, "Wifi Turned Off", Toast.LENGTH_SHORT).show();
            checkedTextView.setText("Wifi Turned Off");
        }
        else
        {
            checkedTextView.setCheckMarkDrawable(R.drawable.ic_check);
            checkedTextView.setChecked(true);
            checkedTextView.setText("Wifi Turned On");
            Toast.makeText(this, "Wifi Turned On", Toast.LENGTH_SHORT).show();
        }


    }
}
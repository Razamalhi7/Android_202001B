package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    CheckBox ch_java,ch_html,ch_android;
    RadioButton radioButton_male,radioButton_female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch_java=findViewById(R.id.ch_java);
        ch_android=findViewById(R.id.ch_android);
        ch_html=findViewById(R.id.ch_html);

        radioButton_male=findViewById(R.id.radioButton_male);
        radioButton_female=findViewById(R.id.radioButton_female);
    }
    boolean isOnn=false;
    public void btn_img(View view)
    {
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();

        ImageButton imageButton =(ImageButton) view;
        if(isOnn)
        {
            imageButton.setImageResource(R.drawable.off);
        }
        else
        {
            imageButton.setImageResource(R.drawable.onn);
        }
        isOnn=!isOnn;
    }

    public void btn_submit(View view) {
        String str=" Subjects\n";

        if (ch_html.isChecked())
            str+="HTML ";
        if(ch_android.isChecked())
            str+="Android ";
        if(ch_java.isChecked())
            str+="JAVA ";

        str+="\nGender\n";

        if (radioButton_male.isChecked())
            str+=" Male ";
        else
        {
            str+=" Female ";
        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
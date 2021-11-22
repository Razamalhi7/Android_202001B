package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> lst=new ArrayList();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);

        lst.add(new Student("Hashir nabi",false));
        lst.add(new Student("Waqqar Raza",true));
        lst.add(new Student("Talha Arif",false));
        lst.add(new Student("Baran Petric",true));
        lst.add(new Student("Faraz Ali",false));
        lst.add(new Student("Sheeraz Ali",true));
        lst.add(new Student("Saad Khan",false));
        lst.add(new Student("Syed Muhammad Taha Raza Riza",true));
        lst.add(new Student("Naqi Abbas",true));
        lst.add(new Student("Raja Asbaan Umar",false));
        lst.add(new Student("Asim Ghaffar",false));
        lst.add(new Student("Saad Khan",false));
        lst.add(new Student("Syed Muhammad Taha Raza Riza",true));
        lst.add(new Student("Naqi Abbas",true));
        lst.add(new Student("Raja Asbaan Umar",false));
        lst.add(new Student("Asim Ghaffar",false));
        StudentAdapter adapter=new StudentAdapter(lst,this);
        listView.setAdapter(adapter);
    }

    public void btn_get_selected(View view)
    {
        String str="";
        for(Student std:lst)
        {
            if(std.IsEligible)
                str+=std.Name+"\n";

        }
        new AlertDialog.Builder(this)
                .setMessage(str)
                .create()
                .show();
    }

    class StudentAdapter extends BaseAdapter
    {
        ArrayList<Student> lst;
        LayoutInflater inflater;
        Context context;

        public StudentAdapter(ArrayList<Student> lst, Context context) {
            this.lst = lst;
            this.context = context;
            inflater= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return lst.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            View v=inflater.inflate(R.layout.item_layout,null);
            CheckBox checkBox=v.findViewById(R.id.ch_iseligible);

            Student std=lst.get(position);

            checkBox.setText(std.Name);
            checkBox.setChecked(std.IsEligible);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    std.IsEligible=isChecked;
                }
            });

            return v;
        }
    }



}






























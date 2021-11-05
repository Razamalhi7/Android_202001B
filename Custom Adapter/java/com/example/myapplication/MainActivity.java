package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Student> lst=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst.add(new Student("101","Muhammad Ali","0321-98653214","Ali@gmail.com,",R.drawable.img1));
        lst.add(new Student("102","Muhammad Asad","0321-98653214","Ali@gmail.com,",R.drawable.img2));
        lst.add(new Student("103","Hashir Nabi","0321-98653214","Ali@gmail.com,",R.drawable.img1));
        lst.add(new Student("104","Taimoor Siqqiqui","0321-98653214","Ali@gmail.com,",R.drawable.img2));
        lst.add(new Student("105","Waqqar Raza","0321-98653214","Ali@gmail.com,",R.drawable.img1));
        lst.add(new Student("106","Baran Naseer","0321-98653214","Ali@gmail.com,",R.drawable.img2));
        lst.add(new Student("107","Hamza Shaikh","0321-98653214","Ali@gmail.com,",R.drawable.img1));
        lst.add(new Student("108","Anosha Rasheed","0321-98653214","Ali@gmail.com,",R.drawable.img2));
        lst.add(new Student("108","Bdullah Albanaja","0321-98653214","Ali@gmail.com,",R.drawable.img2));
        lst.add(new Student("108","Saad Khan","0321-98653214","Ali@gmail.com,",R.drawable.img2));
        lst.add(new Student("108","Marif Ahmed","0321-98653214","Ali@gmail.com,",R.drawable.img2));

        listView=findViewById(R.id.listview);

        StudentAdapter adapter=new StudentAdapter(lst,this);
        listView.setAdapter(adapter);
    }


    class  StudentAdapter extends BaseAdapter
    {
        ArrayList<Student> lst;
        Context context;
        LayoutInflater inflater;

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

            View view=inflater.inflate(R.layout.item_layout,null);

            ImageView img=view.findViewById(R.id.stdImg);
            TextView txtId=view.findViewById(R.id.stdId);
            TextView txtName=view.findViewById(R.id.stdName);
            TextView txtPhone=view.findViewById(R.id.stdPhone);
            TextView txtEmail=view.findViewById(R.id.stdEmail);

            Student std= lst.get(position);
            img.setImageResource(std.Img);
            txtId.setText(std.Id);
            txtName.setText(std.Name);
            txtPhone.setText(std.Phone);
            txtEmail.setText(std.Email);
            return view;
        }
    }




}




























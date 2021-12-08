package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Students extends AppCompatActivity {

    MySqliteDb db;
    ArrayList<Student> lst=new ArrayList<Student>();
    ListView listView;
    StudentAdapter  adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        db=new MySqliteDb(this);
        listView=findViewById(R.id.listview);
        adapter=new StudentAdapter(lst,this);
        listView.setAdapter(adapter);
        fetchStudents("");

    }
    void fetchStudents(String str)
    {
        lst.clear();
        Cursor cursor=db.getStudents(str);
        while (cursor.moveToNext())
        {
            String id=cursor.getString(0);
            String name=cursor.getString(1);
            String phone=cursor.getString(2);
            String email=cursor.getString(3);
            String password=cursor.getString(4);
            byte[] imgArr= cursor.getBlob(5);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imgArr, 0, imgArr.length);
            Student std=new Student(id,name,phone,email,password,bitmap);
            lst.add(std);
        }
        adapter.notifyDataSetChanged();
    }

    class StudentAdapter extends BaseAdapter
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

            View v=inflater.inflate(R.layout.stdlayout,null);
            TextView txtId=v.findViewById(R.id.stdId);
            TextView txtName=v.findViewById(R.id.stdName);
            TextView txtPhone=v.findViewById(R.id.stdPhone);
            TextView txtEmail=v.findViewById(R.id.stdEmail);
            ImageView stdImg=v.findViewById(R.id.stdImg);
            ImageView btnDelete=v.findViewById(R.id.img_btn_delete);
            ImageView btnEdit=v.findViewById(R.id.img_btn_edit);
            ImageView btnDetail=v.findViewById(R.id.img_btn_detail);


            Student obj=lst.get(position);
            txtId.setText(obj.Id);
            txtName.setText(obj.Name);
            txtPhone.setText(obj.Phone);
            txtEmail.setText(obj.Email);
            stdImg.setImageBitmap(obj.Img);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   boolean isDeleted=db.deleteStudent(obj.Id);
                   if(isDeleted)
                   {
                       Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();
                       fetchStudents("");
                   }

                }
            });

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,EditActivity.class);
                    intent.putExtra("StudentId",obj.Id);
                    startActivity(intent);
                }
            });

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(context,DetailActivity.class);
                    intent.putExtra("StudentId",obj.Id);
                    startActivity(intent);

                }
            });

            return v;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_student_activity,menu);

        SearchView  searchView= (SearchView) menu.findItem(R.id.app_bar_search).getActionView();;

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                fetchStudents(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);


    }
}








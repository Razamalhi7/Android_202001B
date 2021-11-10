package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView  listView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        drawerLayout=findViewById(R.id.drawerlayout);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case  0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new HomeFragment()).commit();
                        break;
                    case  2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new SettingFragment()).commit();
                        break;
                    case  3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new HistoryFragment()).commit();
                        break;
                }


                Toast.makeText(MainActivity.this, "position "+position, Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
            }
        });

    }
}
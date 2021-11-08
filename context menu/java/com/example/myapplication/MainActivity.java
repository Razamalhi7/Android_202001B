package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> lst=new ArrayList<>();
    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        lst.add("Hashir");
        lst.add("Raja Asban Umar");
        lst.add("Waqqar raza malhi");
        lst.add("Taimoor Siddiqui");
        lst.add("Abdullah Albanaja");
        lst.add("Saad Khan");
        lst.add("Syed Muhammad Taha Raza Rizvi");
        lst.add("Syed Naqi Abbas");

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lst);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();

        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId()==R.id.item_delete)
        {
            lst.remove(info.position);
            adapter.notifyDataSetChanged();
        }

        return super.onContextItemSelected(item);
    }
}
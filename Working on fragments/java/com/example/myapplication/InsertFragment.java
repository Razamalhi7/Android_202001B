package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class InsertFragment extends Fragment {

    Context context;

    public InsertFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_insert, container, false);
        EditText txtName=view.findViewById(R.id.txtName);
        EditText txtPhone=view.findViewById(R.id.txtPhone);
        EditText txtEmail=view.findViewById(R.id.txtEmail);
        EditText txtPassword=view.findViewById(R.id.txtPassword);
        Button btn_save=view.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=txtName.getText().toString();
                String phone=txtPhone.getText().toString();
                String email=txtEmail.getText().toString();
                String pass=txtPassword.getText().toString();

                MainActivity.lst.add(name+"\n"+phone+"\n"+email+"\n"+pass);
                Toast.makeText(context, "insert Successfully ", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    String title;

public  FirstFragment(String title)
{
    this.title=title;
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_first, container, false);

        TextView textView=view.findViewById(R.id.textview);
        textView.setText(title);

        return view;
    }
}
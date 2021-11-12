package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.Add(new FirstFragment("Hashir Nabi"),"First");
        adapter.Add(new SecondFragment(),"Second");
        adapter.Add(new ThirdFragment(),"Third");
        adapter.Add(new FirstFragment("Taimoor siddique"),"Fourth");
        adapter.Add(new SecondFragment(),"Fifth");
        adapter.Add(new ThirdFragment(),"Sixth");
        adapter.Add(new FirstFragment("Raja Asban Umar"),"seventh");
        adapter.Add(new SecondFragment(),"Eight");
        adapter.Add(new ThirdFragment(),"Nine");
        adapter.Add(new ThirdFragment(),"Tenth");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {

        ArrayList<String> lstTitle=new ArrayList<>();
        ArrayList<Fragment> lstFragments=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public void Add(Fragment fragment,String title)
        {
            lstTitle.add(title);
            lstFragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return lstFragments.get(position);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return lstTitle.get(position);
        }

        @Override
        public int getCount() {
            return lstFragments.size();
        }
    }

}
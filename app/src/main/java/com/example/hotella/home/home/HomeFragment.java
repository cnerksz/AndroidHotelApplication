package com.example.hotella.home.home;

import android.graphics.Point;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotella.R;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPagerHome;
    private HomePagerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout=v.findViewById(R.id.tabLayoutHome);
        viewPagerHome=v.findViewById(R.id.viewPagerHome);
        tabLayout.addTab(tabLayout.newTab().setText("Ana Sayfa"));
        tabLayout.addTab(tabLayout.newTab().setText("Odalar"));
        tabLayout.addTab(tabLayout.newTab().setText("Etkinlik Alanları"));
        tabLayout.addTab(tabLayout.newTab().setText("Havuz&Spa"));
        tabLayout.addTab(tabLayout.newTab().setText("Yakınımda"));
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        adapter=new HomePagerAdapter(fragmentManager,getLifecycle());
        viewPagerHome.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerHome.setCurrentItem(tab.getPosition());
                if (tab.getText()=="Yakınımda"){
                    viewPagerHome.setUserInputEnabled(false);
                }
                else{
                    viewPagerHome.setUserInputEnabled(true);
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPagerHome.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        return v;
    }
}
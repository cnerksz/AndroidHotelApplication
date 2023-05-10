package com.example.hotella.login;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class LoginPagerAdapter extends FragmentStateAdapter {
    public LoginPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
     if(position==1){
         return new AdminFragment();
     }
     return new UserFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

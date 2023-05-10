package com.example.hotella.home.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.hotella.home.home.nearby.NearbyFragment;
import com.example.hotella.home.home.pool.PoolFragment;
import com.example.hotella.home.home.rooms.RoomsFragment;
import com.example.hotella.home.home.tastes.TastesFragment;

public class HomePagerAdapter extends FragmentStateAdapter{
    public HomePagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
      switch (position){
          case 0:return new MainFragment();
          case 1:return new RoomsFragment();
          case 2:return new TastesFragment();
          case 3:return new PoolFragment();
          case 4:return new NearbyFragment();
          default:return new HomeFragment();
      }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

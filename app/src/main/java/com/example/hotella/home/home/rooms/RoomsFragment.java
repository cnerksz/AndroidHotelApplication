package com.example.hotella.home.home.rooms;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotella.R;
import com.example.hotella.home.home.HomeActivity;
import com.example.hotella.home.reception.ReceptionAdapter;
import com.example.hotella.home.reception.ReceptionItems;
import com.example.hotella.login.LoginActivity;

public class RoomsFragment extends Fragment {
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_rooms, container, false);
        recyclerView = v.findViewById(R.id.roomsRecylerview);

        RoomsAdapter productAdapter = new RoomsAdapter(getActivity(), RoomsItems.getData(), new RoomsAdapter.ItemClickListener() {
            @Override
            public void onItemClick(RoomsItems product) {
                switch(product.getImageID()){
                    case R.drawable.location:
                        Intent intent=new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                    case R.drawable.housekeeping:
                    case R.drawable.guest:
                    case R.drawable.technical:
                    case R.drawable.settings:
                }
            }
        });

        recyclerView.setAdapter(productAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);

    return v;
    }
}
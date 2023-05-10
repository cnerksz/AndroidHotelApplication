package com.example.hotella.home.home.tastes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotella.R;

public class TastesFragment extends Fragment {
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_tastes, container, false);
        recyclerView=v.findViewById(R.id.tastesRecylerview);
        TastesAdapter tastesAdapter=new TastesAdapter(getActivity(), TastesItems.getData(), new TastesAdapter.ItemClickListener() {
            @Override
            public void onItemClick(TastesItems product) {
                switch(product.getImageID()){

                }
            }
        });

        recyclerView.setAdapter(tastesAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);


        return v;
    }
}
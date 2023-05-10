package com.example.hotella.home.reception;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotella.R;
import com.example.hotella.login.LoginActivity;

public class ReceptionFragment extends Fragment {
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_reception, container, false);
        recyclerView = v.findViewById(R.id.receptionRecycler);

        ReceptionAdapter productAdapter = new ReceptionAdapter(getActivity(), ReceptionItems.getData(), new ReceptionAdapter.ItemClickListener() {
            @Override
            public void onItemClick(ReceptionItems product) {
                switch(product.getImageID()){
                    case R.drawable.location:
                        Intent intent=new Intent(getActivity(),LoginActivity.class);
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
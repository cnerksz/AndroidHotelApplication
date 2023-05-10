package com.example.hotella.home.notification;




import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotella.R;

public class NotificationFragment extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_notification, container, false);
        recyclerView = v.findViewById(R.id.notificationRecycler);
NotificationAdapter notificationAdapter=new NotificationAdapter(getActivity(), NotificationItems.getData(), new NotificationAdapter.ItemClickListener() {
    @Override
    public void onItemClick(NotificationItems product) {

    }
});
        recyclerView.setAdapter(notificationAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        return v;
    }
}
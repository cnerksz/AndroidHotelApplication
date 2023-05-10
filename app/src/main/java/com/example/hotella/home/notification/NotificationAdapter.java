package com.example.hotella.home.notification;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hotella.R;
import com.example.hotella.home.home.HomeActivity;
import com.example.hotella.home.notification.NotificationAdapter;
import com.example.hotella.home.notification.NotificationItems;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {
    ArrayList<NotificationItems> mProductList;
    LayoutInflater inflater;
    private ItemClickListener mItemClickListener;
    public NotificationAdapter(Context context, ArrayList<NotificationItems> products, ItemClickListener itemClickListener) {
        inflater = LayoutInflater.from(context);
        this.mProductList = products;
        this.mItemClickListener=itemClickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.notification_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NotificationItems selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);
        TextView textView=holder.productAnnouncement;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels/5;
        textView.setLayoutParams(new FrameLayout.LayoutParams(width,height));

        holder.productAnnouncement.setOnClickListener(view->{
            mItemClickListener.onItemClick(mProductList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }
    public interface  ItemClickListener{void onItemClick(NotificationItems product); }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productTitle;
        TextView productAnnouncement;

        public MyViewHolder(View itemView) {
            super(itemView);
            productAnnouncement = (TextView) itemView.findViewById(R.id.announcement);
            productTitle = (TextView) itemView.findViewById(R.id.title);
            productTitle.setOnClickListener(this);

        }

        public void setData(NotificationItems selectedProduct, int position) {

            this.productTitle.setText(selectedProduct.getTitle());
            this.productAnnouncement.setText(selectedProduct.getAnnouncement());




        }



        @Override
        public void onClick(View v) {

        }


    }
}
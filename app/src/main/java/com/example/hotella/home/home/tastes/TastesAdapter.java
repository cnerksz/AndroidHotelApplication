package com.example.hotella.home.home.tastes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hotella.R;


import java.util.ArrayList;

public class TastesAdapter extends RecyclerView.Adapter<TastesAdapter.MyViewHolder> {
    ArrayList<TastesItems> mProductList;
    LayoutInflater inflater;
    private TastesAdapter.ItemClickListener mItemClickListener;
    public TastesAdapter(Context context, ArrayList<TastesItems> products, TastesAdapter.ItemClickListener itemClickListener) {
        inflater = LayoutInflater.from(context);
        this.mProductList = products;
        this.mItemClickListener=itemClickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tastes_item, parent, false);
        MyViewHolder holder=new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TastesItems selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);

        holder.productImage.setOnClickListener(view->{
            mItemClickListener.onItemClick(mProductList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }
    public interface  ItemClickListener{void onItemClick(TastesItems product); }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productName;
        ImageView productImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.reecsName);
            productImage = (ImageView) itemView.findViewById(R.id.rroomsImage);
            productImage.setOnClickListener(this);

        }

        public void setData(TastesItems selectedProduct, int position) {

            this.productName.setText(selectedProduct.getProductName());
            this.productImage.setAdjustViewBounds(true);

            this.productImage.setImageResource(selectedProduct.getImageID());



        }



        @Override
        public void onClick(View v) {

        }


    }
}

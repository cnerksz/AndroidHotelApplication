package com.example.hotella.home.reception;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hotella.R;

import java.util.ArrayList;

public class ReceptionAdapter extends RecyclerView.Adapter<ReceptionAdapter.MyViewHolder> {

    ArrayList<ReceptionItems> mProductList;
    LayoutInflater inflater;
    private ItemClickListener mItemClickListener;
    public ReceptionAdapter(Context context, ArrayList<ReceptionItems> products, ItemClickListener itemClickListener) {
        inflater = LayoutInflater.from(context);
        this.mProductList = products;
        this.mItemClickListener=itemClickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.reception_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ReceptionItems selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);
        holder.productImage.setOnClickListener(view->{
            mItemClickListener.onItemClick(mProductList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }
public interface  ItemClickListener{void onItemClick(ReceptionItems product); }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productName;
        ImageView productImage, deleteproduct;

        public MyViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.productName);
            productImage = (ImageView) itemView.findViewById(R.id.productImage);
            deleteproduct = (ImageView) itemView.findViewById(R.id.skipImage);
            productImage.setOnClickListener(this);

        }

        public void setData(ReceptionItems selectedProduct, int position) {

            this.productName.setText(selectedProduct.getProductName());
            this.productImage.setBackgroundResource(selectedProduct.getImageID());



        }


        @Override
        public void onClick(View v) {

        }


    }
}
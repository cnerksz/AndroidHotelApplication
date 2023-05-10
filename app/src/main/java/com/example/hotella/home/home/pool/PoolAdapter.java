package com.example.hotella.home.home.pool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hotella.R;

import java.util.ArrayList;

public class PoolAdapter extends RecyclerView.Adapter<PoolAdapter.MyViewHolder> {
    ArrayList<PoolItems> mProductList;
    LayoutInflater inflater;
    private PoolAdapter.ItemClickListener mItemClickListener;
    public PoolAdapter(Context context, ArrayList<PoolItems> products,ItemClickListener itemClickListener) {
        inflater = LayoutInflater.from(context);
        this.mProductList = products;
        this.mItemClickListener=itemClickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.pool_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PoolItems selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);

        holder.productImage.setOnClickListener(view->{
            mItemClickListener.onItemClick(mProductList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }
    public interface  ItemClickListener{void onItemClick(PoolItems product); }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productName;
        ImageView productImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.proomsName);
            productImage = (ImageView) itemView.findViewById(R.id.proomsImage);
            productImage.setOnClickListener(this);

        }

        public void setData(PoolItems selectedProduct, int position) {

            this.productName.setText(selectedProduct.getProductName());
            this.productImage.setAdjustViewBounds(true);

            this.productImage.setImageResource(selectedProduct.getImageID());



        }



        @Override
        public void onClick(View v) {

        }


    }
}

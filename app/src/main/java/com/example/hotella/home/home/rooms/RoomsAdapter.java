package com.example.hotella.home.home.rooms;
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

import java.util.ArrayList;
public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.MyViewHolder> {
    ArrayList<RoomsItems> mProductList;
    HomeActivity activity=new HomeActivity();
    ImageView imageView;
    LayoutInflater inflater;
    private ItemClickListener mItemClickListener;
    public RoomsAdapter(Context context, ArrayList<RoomsItems> products, ItemClickListener itemClickListener) {
        inflater = LayoutInflater.from(context);
        this.mProductList = products;
        this.mItemClickListener=itemClickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rooms_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RoomsItems selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);
        ImageView imageView=holder.productImage;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels/4;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(width,height));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.productImage.setOnClickListener(view->{
            mItemClickListener.onItemClick(mProductList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }
    public interface  ItemClickListener{void onItemClick(RoomsItems product); }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productName;
        ImageView productImage;

        public MyViewHolder(View itemView) {
            super(itemView);
           // productName = (TextView) itemView.findViewById(R.id.roomsName);
            productImage = (ImageView) itemView.findViewById(R.id.roomsImage);
            productImage.setOnClickListener(this);

        }

        public void setData(RoomsItems selectedProduct, int position) {

           // this.productName.setText(selectedProduct.getProductName());
            this.productImage.setAdjustViewBounds(true);

            this.productImage.setBackgroundResource(selectedProduct.getImageID());



        }



        @Override
        public void onClick(View v) {

        }


    }
}
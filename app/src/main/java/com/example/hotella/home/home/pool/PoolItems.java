package com.example.hotella.home.home.pool;


import com.example.hotella.R;


import java.util.ArrayList;

public class PoolItems {

    private String productName;
    private int imageID;

    public PoolItems() {
    }

    public PoolItems(int imageID, String productName) {
        this.imageID = imageID;
        this.productName = productName;

    }


    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public static ArrayList<PoolItems> getData() {
        ArrayList<PoolItems> productList = new ArrayList<PoolItems>();
        int productImages[] = {R.drawable.location, R.drawable.housekeeping, R.drawable.technical};
        String[] productNames = {"Standart", "Aile", "Ekonomik"};
        for (int i = 0; i < productImages.length; i++) {
            PoolItems temp = new PoolItems();
            temp.setImageID(productImages[i]);
            temp.setProductName(productNames[i]);
            productList.add(temp);
        }


        return productList;


    }
}

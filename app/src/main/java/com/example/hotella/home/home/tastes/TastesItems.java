package com.example.hotella.home.home.tastes;

import com.example.hotella.R;


import java.util.ArrayList;

public class TastesItems {


    private String productName;
    private int imageID;

    public TastesItems() {
    }

    public TastesItems(int imageID, String productName) {
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


    public static ArrayList<TastesItems> getData() {
        ArrayList<TastesItems> productList = new ArrayList<TastesItems>();
        int productImages[] = {R.drawable.location, R.drawable.housekeeping, R.drawable.technical};
        String[] productNames = {"Standart", "Aile", "Ekonomik"};
        for (int i = 0; i < productImages.length; i++) {
            TastesItems temp = new TastesItems();
            temp.setImageID(productImages[i]);
            temp.setProductName(productNames[i]);
            productList.add(temp);
        }


        return productList;


    }
}

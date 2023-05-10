package com.example.hotella.home.home.rooms;

import com.example.hotella.R;
import com.example.hotella.home.reception.ReceptionItems;

import java.util.ArrayList;

public class RoomsItems {


    private String productName;
    private int imageID;

    public RoomsItems() {
    }

    public RoomsItems(int imageID, String productName) {
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


    public static ArrayList<RoomsItems> getData() {
        ArrayList<RoomsItems> productList = new ArrayList<RoomsItems>();
        int productImages[] = {R.drawable.location, R.drawable.housekeeping, R.drawable.technical};
        String[] productNames = {"Standart", "Aile", "Ekonomik"};
        for (int i = 0; i < productImages.length; i++) {
            RoomsItems temp = new RoomsItems();
            temp.setImageID(productImages[i]);
            temp.setProductName(productNames[i]);
            productList.add(temp);
        }


        return productList;


    }
}

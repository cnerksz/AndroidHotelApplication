package com.example.hotella.home.reception;

import com.example.hotella.R;

import java.util.ArrayList;

public class ReceptionItems {


    private String productName;
    private int imageID;

    public ReceptionItems() {
    }

    public ReceptionItems(int imageID, String productName) {
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



    public static ArrayList<ReceptionItems> getData() {
        ArrayList<ReceptionItems> productList = new ArrayList<ReceptionItems>();
        int productImages[] = {R.drawable.location,R.drawable.housekeeping,R.drawable.technical,R.drawable.guest,R.drawable.settings};
        String[] productNames = {"Lokasyon Siparişi","Kat Hizmetleri","Teknik Servis","Misafir Ayarları","Uygulama Ayarları"};
        for (int i = 0; i < productImages.length; i++) {
            ReceptionItems temp = new ReceptionItems();
            temp.setImageID(productImages[i]);
            temp.setProductName(productNames[i]);
            productList.add(temp);
        }


        return productList;


    }
}
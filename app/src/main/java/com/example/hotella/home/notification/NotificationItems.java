package com.example.hotella.home.notification;

import java.util.ArrayList;

public class NotificationItems {

    private String title;
    private String announcement;

    public NotificationItems() {
    }

    public NotificationItems(String title, String announcement) {

        this.title = title;
        this.announcement = announcement;
    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
    public static ArrayList<NotificationItems> getData(){
        ArrayList<NotificationItems> productList=new ArrayList<NotificationItems>();
        String[] titles={"cannn","olaylarrr","olaylar","daha neleler","aboo"};
        String announcements="lorem sad sajd kalsd sahdalsd asd sadjk lasd la sdja lsdja sa dlkjdsa jd";
        for(int i=0;i< titles.length;i++){
            NotificationItems temp=new NotificationItems();
            temp.setTitle(titles[i]);
            temp.setAnnouncement(announcements);
        productList.add(temp);
        }
        return productList;

    }
}

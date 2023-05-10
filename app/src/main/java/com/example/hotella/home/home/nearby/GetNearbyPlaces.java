package com.example.hotella.home.home.nearby;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class GetNearbyPlaces extends AsyncTask<Object,String,String> {
    private String googleplaceData,url;
    private GoogleMap mMap;
    @Override
    protected String doInBackground(Object... objects) {
        try {
        mMap=(GoogleMap) objects[0];
        url=(String) objects[1];
        Log.e("ERRRORRR",url);
        DownloadURL downloadUrl=new DownloadURL();
        googleplaceData= downloadUrl.ReadTheURL(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return googleplaceData;
    }

    @Override
    protected void onPostExecute(String s) {
        try{
            JSONObject jsonObject=new JSONObject(s);
            JSONArray jsonArray=jsonObject.getJSONArray("results");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                JSONObject getLocation=jsonObject1.getJSONObject("geometry").getJSONObject("location");

                String lat=getLocation.getString("lat");
                String lng=getLocation.getString("lng");
                JSONObject getName=jsonArray.getJSONObject(i);
                String name=getName.getString("name");

                LatLng latLng=new LatLng(Double.parseDouble(lat),Double.parseDouble(lng));

                MarkerOptions markerOptions=new MarkerOptions();
                markerOptions.title(name);
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                markerOptions.position(latLng);
                mMap.addMarker(markerOptions);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));

            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }


}

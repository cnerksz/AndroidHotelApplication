package com.example.hotella.home.home.nearby;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadURL {
    public String ReadTheURL(String placeURL) throws IOException {
        String Data= "";
        InputStream inputStream=null;
        HttpURLConnection httpURLConnection=null;
        try {
            URL url=new URL(placeURL);
            httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer=new StringBuffer();
            String line= "";

            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }
            Data=stringBuffer.toString();
            bufferedReader.close();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            inputStream.close();
            httpURLConnection.disconnect();
        }
        Log.e("anan",Data);
        return Data;
    }
}

package com.example.gadsleaderboard;

import android.net.Uri;
import android.support.v4.os.IResultReceiver;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ApiUtil {

    static public String BASE_URL = "https://gadsapi.herokuapp.com";



    //function to build URL
    static public URL urlBuilder(String link) throws MalformedURLException {

        String urlString = BASE_URL +  "/api/" + link;

        URL fullUrl = new URL(urlString);



        return fullUrl;
    }

  //function to connect to the api and fetch jsn data

    public  static String getJson(URL url) throws IOException {

        String jsonResult = null;

        HttpURLConnection gadsConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream datain =  gadsConnection.getInputStream();

            Scanner s = new Scanner(datain).useDelimiter("\\A");

            boolean hasData = s.hasNext();

            if (hasData){
                jsonResult = s.next();
            }
            else{
                jsonResult = null;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            gadsConnection.disconnect();
        }


        return jsonResult;
    }



}

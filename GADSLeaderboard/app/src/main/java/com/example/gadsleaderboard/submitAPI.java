package com.example.gadsleaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class submitAPI {

    private static Retrofit retrofit = null;

    public  static APIservice getClient(){

        // change your base URL
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://docs.google.com/forms/d/e/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Creating object for our interface
        APIservice api = retrofit.create(APIservice.class);
        return api; // return the APIInterface object




    }

}

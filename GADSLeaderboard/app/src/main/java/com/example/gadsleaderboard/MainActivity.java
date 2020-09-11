package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.gadsleaderboard.ApiUtil.getJson;
import static com.example.gadsleaderboard.ApiUtil.urlBuilder;

public class MainActivity extends AppCompatActivity {

    //private URL gadsUrl;
    //private TextView textviewLeaderboard;
    private learningAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //textviewLeaderboard = (TextView) findViewById(R.id.tvgads);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final leaderBoardApi leaderBoardApi = retrofit.create(leaderBoardApi.class);

        Call<ArrayList<learningLeader>> call = leaderBoardApi.getlearningLeader();

        call.enqueue(new Callback<ArrayList<learningLeader>>() {
            @Override
            public void onResponse(Call<ArrayList<learningLeader>> call, Response<ArrayList<learningLeader>> response) {

                if (!response.isSuccessful()) {
                    //textviewLeaderboard.setText("Code: " + response.code());
                }

                generateDataList(response.body());
                //List<learningLeader> mLearningLeaders = response.body();



         /*       for (learningLeader learningLeader : learningLeaders) {
                    String content = "";
                    content += learningLeader.getName() + "\n";
                    content += learningLeader.getHours() + " leaning hours, " + learningLeader.getCountry() + "\n\n";

                    //textviewLeaderboard.append(content);

                }*/


            }

            @Override
            public void onFailure(Call<ArrayList<learningLeader>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();


            }





        });


/*

        try {
            URL gadsUrl = urlBuilder("hours");
            new GadsQuesryTask().execute(gadsUrl);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/





    /*public class GadsQuesryTask extends AsyncTask<URL, Void, String>{
        String json = null;

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];

            try {
                json = getJson(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return json;
        }

        @Override
        protected void onPostExecute(String json) {
            super.onPostExecute(json);

            textviewLeaderboard.setText(json);

        }
    }*/

    }

     public void generateDataList(ArrayList<learningLeader> learningLeaders){

         RecyclerView learningRecyclerView  = (RecyclerView) findViewById(R.id.learningRecycler);

         adapter = new learningAdapter(this, learningLeaders);

         learningRecyclerView.setAdapter(adapter);
         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
         learningRecyclerView.setLayoutManager(layoutManager);





     }

}


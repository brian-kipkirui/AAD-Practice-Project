package com.example.gadsleaderboard;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SkillActivity extends AppCompatActivity {

    private skillAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.skill_layout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ///final leaderBoardApi leaderBoardApi = retrofit.create(leaderBoardApi.class);

        //Call<ArrayList<learningLeader>> call = leaderBoardApi.getlearningLeader();

        final skilliqApi skillApi = retrofit.create(skilliqApi.class);

        Call<ArrayList<skillLeader>> call = skillApi.getSkillLeader();//leaderBoardApi.getlearningLeader();

        call.enqueue(new Callback<ArrayList<skillLeader>>() {
            @Override
            public void onResponse(Call<ArrayList<skillLeader>> call, Response<ArrayList<skillLeader>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<skillLeader>> call, Throwable t) {
                Toast.makeText(SkillActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });



    }

    public void generateDataList(ArrayList<skillLeader> skillLeaders){

        RecyclerView learningRecyclerView  = (RecyclerView) findViewById(R.id.skillRecycler);

        adapter = new skillAdapter(this, skillLeaders);

        learningRecyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SkillActivity.this);
        learningRecyclerView.setLayoutManager(layoutManager);





    }


}

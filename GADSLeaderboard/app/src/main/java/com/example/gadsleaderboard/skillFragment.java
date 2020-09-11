package com.example.gadsleaderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class skillFragment extends Fragment {

    private skillAdapter adapter;
    // private RecyclerView learningRecyclerView;
    private View skillsView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View skillsView =  inflater.inflate(R.layout.fragment_skill, container, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final skilliqApi skillApi = retrofit.create(skilliqApi.class);


        Call<ArrayList<skillLeader>> call = skillApi.getSkillLeader();//leaderBoardApi.getlearningLeader();

        call.enqueue(new Callback<ArrayList<skillLeader>>() {
            @Override
            public void onResponse(Call<ArrayList<skillLeader>> call, Response<ArrayList<skillLeader>> response) {

                ArrayList<skillLeader> skillLeaders = response.body();

                RecyclerView skillsRecyclerView  = getView().findViewById(R.id.skillsRecycler);

                adapter = new skillAdapter(getContext(), skillLeaders);

                skillsRecyclerView.setAdapter(adapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                skillsRecyclerView.setLayoutManager(layoutManager);


            }

            @Override
            public void onFailure(Call<ArrayList<skillLeader>> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });


    return  skillsView;
    }
}
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


public class learningFragment extends Fragment {

    private learningAdapter adapter;
   // private RecyclerView learningRecyclerView;
    private View learningView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View learningView =  inflater.inflate(R.layout.fragment_learning, container, false);


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

                ArrayList<learningLeader> learningLeaders = response.body();

                RecyclerView learningRecyclerView  = getView().findViewById(R.id.learningRecycler);

                adapter = new learningAdapter(getContext(), learningLeaders);

                learningRecyclerView.setAdapter(adapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                learningRecyclerView.setLayoutManager(layoutManager);

               // generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<learningLeader>> call, Throwable t) {
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();


            }

        });





        return learningView;

    }


    public void generateDataList(ArrayList<learningLeader> learningLeaders){

        RecyclerView learningRecyclerView  = learningView.findViewById(R.id.learningRecycler);

        adapter = new learningAdapter(getContext(), learningLeaders);

        learningRecyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        learningRecyclerView.setLayoutManager(layoutManager);





    }

}
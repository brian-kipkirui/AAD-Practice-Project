package com.example.gadsleaderboard;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface leaderBoardApi {

    String HOURS = "/api/hours";

    @GET(HOURS) //annotate methods
    Call<ArrayList<learningLeader>> getlearningLeader(); // retrofit will create the implememtation of this function
}

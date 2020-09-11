package com.example.gadsleaderboard;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface skilliqApi {

    String SKILLIQ = "/api/skilliq";

    @GET(SKILLIQ) //annotate methods
    Call<ArrayList<skillLeader>> getSkillLeader(); // retrofit will create the implememtation of this function
}

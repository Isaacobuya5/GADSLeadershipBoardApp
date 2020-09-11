package com.example.gadsleadershipboardapp.services;

import com.example.gadsleadershipboardapp.model.LearningLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningLeadersService {

    @GET("api/hours")
    Call<List<LearningLeader>> getLearningLeaders();
}

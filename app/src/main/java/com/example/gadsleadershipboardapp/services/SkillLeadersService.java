package com.example.gadsleadershipboardapp.services;


import com.example.gadsleadershipboardapp.model.SkillIQLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillLeadersService {

    @GET("api/skilliq")
    Call<List<SkillIQLeader>> getSkillIQLeaders();
}

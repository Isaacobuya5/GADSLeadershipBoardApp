package com.example.gadsleadershipboardapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gadsleadershipboardapp.adapters.SkillLeadersAdapter;
import com.example.gadsleadershipboardapp.model.SkillIQLeader;
import com.example.gadsleadershipboardapp.services.ServiceBuilder;
import com.example.gadsleadershipboardapp.services.SkillLeadersService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillLeadersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillLeadersFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private List<SkillIQLeader> mSkillIQLeaderList;
    private SkillLeadersAdapter mSkillLeadersAdapter;

    public SkillLeadersFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SkillLeadersFragment newInstance() {
        SkillLeadersFragment fragment = new SkillLeadersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//      ;
//        }
        // getting a reference to the service interface
        SkillLeadersService skillLeadersService = ServiceBuilder.buildService(SkillLeadersService.class);
        Call<List<SkillIQLeader>> skillLeaderApiCall = skillLeadersService.getSkillIQLeaders();

        skillLeaderApiCall.enqueue(new Callback<List<SkillIQLeader>>() {
            @Override
            public void onResponse(Call<List<SkillIQLeader>> call, Response<List<SkillIQLeader>> response) {
                mSkillIQLeaderList = response.body();
                mSkillLeadersAdapter = new SkillLeadersAdapter(getActivity(), mSkillIQLeaderList);
                mRecyclerView.setAdapter(mSkillLeadersAdapter);
            }

            @Override
            public void onFailure(Call<List<SkillIQLeader>> call, Throwable t) {
                System.out.println("An error occured.. Could not fetch from Api");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_skill_leaders, container, false);
        mRecyclerView = root.findViewById(R.id.skillIQRecyclerViewer);
        // associate recyclerviewer with layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }
}
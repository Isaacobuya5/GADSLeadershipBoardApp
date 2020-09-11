package com.example.gadsleadershipboardapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gadsleadershipboardapp.adapters.LearningLeadersAdapter;
import com.example.gadsleadershipboardapp.model.LearningLeader;
import com.example.gadsleadershipboardapp.services.LearningLeadersService;
import com.example.gadsleadershipboardapp.services.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningLeadersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningLeadersFragment extends Fragment {


    private List<LearningLeader> mLearningLeadersList;
    private LearningLeadersAdapter mLearningLeadersAdapter;
    private RecyclerView mRecyclerView;

    public LearningLeadersFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LearningLeadersFragment newInstance() {
        LearningLeadersFragment fragment = new LearningLeadersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//
//        }

        // getting a reference to the service interface
        LearningLeadersService learningLeadersService = ServiceBuilder.buildService(LearningLeadersService.class);
        Call<List<LearningLeader>> learnerLeaderApiCall = learningLeadersService.getLearningLeaders();



        learnerLeaderApiCall.enqueue(new Callback<List<LearningLeader>>() {
            @Override
            public void onResponse(Call<List<LearningLeader>> call, Response<List<LearningLeader>> response) {
                mLearningLeadersList = response.body();
                mLearningLeadersAdapter = new LearningLeadersAdapter(getActivity(), mLearningLeadersList);
                mRecyclerView.setAdapter(mLearningLeadersAdapter);
            }

            @Override
            public void onFailure(Call<List<LearningLeader>> call, Throwable t) {
//                Toast.makeText("this", "Sorry failed to retrive learner leaders", Toast.LENGTH_SHORT);
                System.out.println("An error occured.. Could not fetch from Api");
            }
        });

//        // get a reference to the adapter
//
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        // get  reference to RecyclerViewer
        mRecyclerView = root.findViewById(R.id.learnRecyclerViewer);
        // associate recyclerviewer with layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // associate with an adapter
//        if (mLearningLeadersAdapter != null)
        // Inflate the layout for this fragment
        return root;
    }
}
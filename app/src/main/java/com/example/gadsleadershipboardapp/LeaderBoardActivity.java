package com.example.gadsleadershipboardapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class LeaderBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

//        // getting a reference to the toolbar
//        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolBar);
//        setSupportActionBar(toolbar);

        // get reference to the submit button
        final Button submitButton = (Button) findViewById(R.id.submit_button);

        // set click listener on the button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeaderBoardActivity.this, SubmitProjectActivity.class);
                startActivity(intent);
            }
        });

        // getting the Tab Layout reference
        TabLayout tabLayout = (TabLayout) findViewById(R.id.pageTab);
//        // tab items
//        TabItem tabLearningLeaders = (TabItem) findViewById(R.id.learningLeaders);
//        TabItem skillLeaders = (TabItem) findViewById(R.id.skillLeaders);

        // reference to ViewPager
        ViewPager2 viewPager = (ViewPager2) findViewById(R.id.viewPager);
        viewPager.setAdapter(new PagerAdapter(this, 2));

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch(position) {
                    case 0:
                        tab.setText(R.string.learning_leaders);
                    case 1:
                        tab.setText(R.string.skill_iq_leaders);
                }
            }
        }).attach();

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
//        return true;
//    }
}
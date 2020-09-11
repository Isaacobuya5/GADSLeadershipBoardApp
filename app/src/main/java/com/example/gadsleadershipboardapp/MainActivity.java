package com.example.gadsleadershipboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    public static final int DELAY_HOME_ACTIVITY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(this, LeaderBoardActivity.class);
//        startActivity(intent);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent firstActivity = new Intent(MainActivity.this, LeaderBoardActivity.class);
                startActivity(firstActivity);
                finish();
            }
        }, DELAY_HOME_ACTIVITY);

    }
}
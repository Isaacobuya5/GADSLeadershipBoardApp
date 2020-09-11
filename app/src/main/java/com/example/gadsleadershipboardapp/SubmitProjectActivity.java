package com.example.gadsleadershipboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubmitProjectActivity extends AppCompatActivity {

    private TextView mFirstName;
    private TextView mLastName;
    private TextView mEmailAddress;
    private TextView mGitHubLink;

    public SubmitProjectActivity(){};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_project);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // get links to the views
        mFirstName = (TextView) findViewById(R.id.firstName);
        mLastName = (TextView) findViewById(R.id.lastName);
        mEmailAddress = (TextView) findViewById(R.id.emailAddress);
        mGitHubLink = (TextView) findViewById(R.id.githubLink);

        // submit button
        Button submitButton = (Button) findViewById(R.id.submitBtn);

        // submitting the form
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting the values
                String firstName = mFirstName.getText().toString();
                String lastName = mLastName.getText().toString();
                String emailAddress = mEmailAddress.getText().toString();
                String gitHubLink = mGitHubLink.getText().toString();

                Intent intent = new Intent(SubmitProjectActivity.this, ProjectSubmissionConfirmation.class);
                intent.putExtra("firstName", firstName);
                intent.putExtra("lastName", lastName);
                intent.putExtra("emailAddress", emailAddress);
                intent.putExtra("gitHubLink", gitHubLink);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
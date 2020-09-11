package com.example.gadsleadershipboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gadsleadershipboardapp.services.GoogleServiceBuilder;
import com.example.gadsleadershipboardapp.services.SubmitToGoogleFormsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmissionConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission_confirmation);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        getWindow().setLayout((int) (width * .9), (int) (height * .6));

        // Getting extras from the intent
        Intent intent = getIntent();
        final String fName = intent.getStringExtra("firstName");
        final String lName =  intent.getStringExtra("lastName");
        final String eMail =  intent.getStringExtra("emailAddress");
        final String gitLink = intent.getStringExtra("gitHubLink");

        // get reference to the service builder
        final SubmitToGoogleFormsService googleServiceBuilder = GoogleServiceBuilder.buildService(SubmitToGoogleFormsService.class);

        // get reference to the submission confirmation button
        Button button = (Button) findViewById(R.id.submit_project);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Void> submitProject = googleServiceBuilder.submitProject(fName,lName, gitLink, eMail);

                submitProject.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Intent intent = new Intent(ProjectSubmissionConfirmation.this, SubmissionSuccesful.class);
                        Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Intent intent = new Intent(ProjectSubmissionConfirmation.this, SubmissionFailed.class);
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(intent);
                    }
                });
            }
        });


    }
}
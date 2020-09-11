package com.example.gadsleaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitActivity extends AppCompatActivity {

    //SignUpResponse signUpResponsesData;
    private EditText nameText;
    private EditText lastText;
    private EditText emailText;
    private EditText linkText;
    private Button submitButton;
    APIservice submissionAPI;
    String name;
    String lastName;
    String email;
    String link;
    //private APIservice submitAPI;
    private static final String TAG = "SubmitActivity";




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submision);

        nameText = (EditText) findViewById(R.id.editTextFname);
        lastText = (EditText) findViewById(R.id.editTextLname);
        emailText = (EditText) findViewById(R.id.editTextEmail);
        linkText = (EditText) findViewById(R.id.editTextLink);
        submitButton = (Button) findViewById(R.id.submitButton);




        /*Gson gson = new GsonBuilder()
                .setLenient()
                .create();
*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        submissionAPI = retrofit.create(APIservice.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i(TAG, "Button Clicked");
                createSubmission();

            }
        });

    }

    public void createSubmission(){

        name = nameText.getText().toString().trim();
        lastName = lastText.getText().toString().trim();
        email = emailText.getText().toString().trim();
        link = linkText.getText().toString().trim();

        Log.i(TAG, "Submit data method called");
       Submission submission = new Submission(email, name, lastName, link);
        Call<Submission> call = submissionAPI.createSubmission(submission);



        //Call<Submission> call = submissionAPI.createSubmission(email, name, lastName,link);

        call.enqueue(new Callback<Submission>() {
            @Override
            public void onResponse(Call<Submission> call, Response<Submission> response) {

                Log.i(TAG, "Submission made");

                if(!response.isSuccessful()) {
                    Log.i(TAG, "Submission unSuccessful!"+ response.code());

                    try {
                        Log.i("Error code 400",response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                 /*   if (response.code() == 400) {
                        try {
                            Log.i("Error code 400",response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
*/

                }
                Log.i(TAG, "Submission Successful!"+ response.code());

                Toast.makeText(SubmitActivity.this, "Submission Successful!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Submission> call, Throwable t) {

                Log.i(TAG, "Submission  NOT Successful! " + t.getMessage());
                Toast.makeText(SubmitActivity.this, "Submission not Succesful...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });


    }
}

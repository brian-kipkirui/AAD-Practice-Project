package com.example.gadsleaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitActivity extends AppCompatActivity {

    private EditText nameText;
    private EditText lastText;
    private EditText emailText;
    private EditText linkText;
    private Button submitButton;
    String name;
    String lastName;
    String email;
    String link;
    private APIservice submitAPI;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submision);

        nameText = (EditText) findViewById(R.id.editTextFname);
        lastText = (EditText) findViewById(R.id.editTextLname);
        emailText = (EditText) findViewById(R.id.editTextEmail);
        linkText = (EditText) findViewById(R.id.editTextLink);
        submitButton = (Button) findViewById(R.id.submitButton);






        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIservice submitAPI = retrofit.create(APIservice.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameText.getText().toString();
                lastName = lastText.getText().toString();
                email = emailText.getText().toString();
                link = linkText.getText().toString();

                SubmitData();

            }
        });

    }

    public void SubmitData(){

        Submission submission = new Submission(email,name,lastName,link);

        Call<Submission> call = submitAPI.createSubmission(email, name, lastName,link);

        call.enqueue(new Callback<Submission>() {


            @Override
            public void onResponse(Call<Submission> call, Response<Submission> response) {

                if(response.isSuccessful()) {

                    Toast.makeText(SubmitActivity.this, "Submission Successful!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Submission> call, Throwable t) {
                Toast.makeText(SubmitActivity.this, "Submission not Succesful...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });


    }
}

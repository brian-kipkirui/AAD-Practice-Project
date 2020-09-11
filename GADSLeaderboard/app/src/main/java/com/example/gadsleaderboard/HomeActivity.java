package com.example.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button learningButton;
    Button skillButton;
    Button submitProject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);


        this.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new skillFragment())
                .addToBackStack(null).commit();

        learningButton = (Button) findViewById(R.id.learning_button);
        skillButton = (Button) findViewById(R.id.skill_button);
        submitProject = (Button) findViewById(R.id.submit_button);

        learningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentHome);
            }
        });

        skillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), SkillActivity.class);
                startActivity(intent2);

            }
        });

        submitProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), SubmitActivity.class);
                startActivity(intent3);

            }
        });




    }
}

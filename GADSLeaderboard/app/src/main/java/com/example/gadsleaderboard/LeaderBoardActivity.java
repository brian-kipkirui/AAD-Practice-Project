package com.example.gadsleaderboard;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
//import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar   toolbar1;
    private TabsAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        toolbar1 = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar1);

        getSupportActionBar().setTitle("LEADERBOARD");
        toolbar1.setTitleTextColor(Color.WHITE);

        Button toolBarBtn = (Button)findViewById(R.id.toolBarBtn);
        toolBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), SubmitActivity.class);
                startActivity(intent3);
            }
        });


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        adapter = new TabsAdapter(getSupportFragmentManager());
        adapter.addFragment(new learningFragment(), "Learning");
        adapter.addFragment(new skillFragment(), "Skills");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);






    }







}
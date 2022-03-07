package com.raheel.androidpictureinpicture;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {


    private ArrayList<Model> videoList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        populateArrayList();

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(videoList, this);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void populateArrayList() {
        videoList.add(new Model("Big Buck Bunny", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"));
        videoList.add(new Model("We are going on bull run", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4"));
        videoList.add(new Model("Volkswagen GTI Review", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"));
        videoList.add(new Model("For Bigger Blazes", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"));
        videoList.add(new Model("Subaru Outback On Street And Dirt", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        videoList.add(new Model("What care can you get for ten grand?", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"));
    }

    @Override
    public void onItemClick(Model model) {

        startActivity(new Intent(this, PiPActivity.class).putExtra("videoUrl", model.videoUrl));

    }
}

package com.bvpieee.ui.teams;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bvpieee.R;

import java.util.ArrayList;
import java.util.List;

public class HKN_Team extends AppCompatActivity {

    private RecyclerView HKNRecyclerview;
    private List<TeamFragModelClass> memberChapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hkn_team);

        memberChapter=new ArrayList<>();
        memberChapter.add(new TeamFragModelClass("Himani Negi","President",R.drawable.himaninegi,
                "Hi, This is me, Himani Negi.Currently I am a student developer in Google summer of code under redhenlab organization. " +
                "I am working under Image and audio clustering project. Previosuly I was research intern in IIIT-D where I worked in analysing the collusive behaviour in social networking site." +
                "Creating a world with innovative ideas is something a part of my vision and I never look back to put efforts for it.",
                "https://www.linkedin.com/in/himaninegi/"));


        memberChapter.add(new TeamFragModelClass("Kshitij Sidana","Vice-President",R.drawable.kshitijsidana,
                "Fueled by fascination. Driven by logic. Jack of all but master of some. Domain of work: Robotics and Computer Vision.",
                "https://www.linkedin.com/in/kshitij-sidana/"));

        HKNRecyclerview=findViewById(R.id.rvHKN);
        RecyclerViewAdapterCSTeam recyclerViewAdapter=new RecyclerViewAdapterCSTeam(this,memberChapter);
        HKNRecyclerview.setAdapter(recyclerViewAdapter);
        HKNRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        HKNRecyclerview.setItemViewCacheSize(20);
        HKNRecyclerview.setDrawingCacheEnabled(true);
        HKNRecyclerview.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

    }
}

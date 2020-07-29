package com.bvpieee.ui.teams;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bvpieee.R;

import java.util.ArrayList;
import java.util.List;

public class WIE_Team extends AppCompatActivity {

    private RecyclerView WIERecyclerView;
    private List<TeamFragModelClass> memberChapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wie_team);

        memberChapter= new ArrayList<>();
        memberChapter.add(new TeamFragModelClass("Eva Sarin","Chairperson, WIE",R.drawable.evasarin,"I am deeply interested in the field of cognitive computing and research. Other than that, I am passionate about cooking as well." +
                "I am exploring Deep Learning and working on neural networks. My research at CCC, IIIT Allahabad during my summer internship 2020 was related to EEGLAB analysis."));
        memberChapter.add(new TeamFragModelClass("Aakriti Jain","Vice-Chairperson, WIE",R.drawable.aakritijain,"I am an enthusiastic learner, love to grab new opportunities and take lead from the front. " +
                "Managing the team and events. I've always been inclined towards the managerial stuff. I have started exploring the technical side too,  with ML and Web Design"));
        memberChapter.add(new TeamFragModelClass("Keya Deshmukh","Vice-Chairperson, WIE",R.drawable.keyadeshmukh,"A keen learner and always want to explore things. Domain of Work: Machine Learning and Graphic Designing"));
        memberChapter.add(new TeamFragModelClass("Tanya Mahajan","Secretary, WIE",R.drawable.tanyamahajan,"I like to do coding and I am fond of series and listening to music."));
        memberChapter.add(new TeamFragModelClass("Astha Chabra", "WIE STAR(Student Teacher and Research) Coordinator",R.drawable.asthachhabra,"An enthusiastic person eager to contribute to team success through hard work, attention to go in detail and organisational skills. Motivated to learn,grow and excel professionally." +
                "More inclined towards technical side rather than management side."));
        memberChapter.add(new TeamFragModelClass("Nikita Tewary","WIE Representative",R.drawable.nikitatewary,"I am hardworking and determined. Representing and helping WIE grow."));

        WIERecyclerView=findViewById(R.id.rvWIE);
        RecyclerViewAdapterCSTeam recyclerViewAdapter=new RecyclerViewAdapterCSTeam(this,memberChapter);
        WIERecyclerView.setAdapter(recyclerViewAdapter);
        WIERecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

}

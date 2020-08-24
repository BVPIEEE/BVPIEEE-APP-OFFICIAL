package com.bvpieee.ui.teams;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bvpieee.R;
import com.bvpieee.adapters.RecyclerViewAdapterCSTeam;
import com.bvpieee.models.TeamFragModelClass;

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

        memberChapter.add(new TeamFragModelClass("Eva Sarin","Chairperson, WIE",R.drawable.evasarin,
                "I am deeply interested in the field of cognitive computing and research. Other than that, I am passionate about cooking as well." +
                        "I am exploring Deep Learning and working on neural networks. My research at CCC, IIIT Allahabad during my summer internship 2020 was related to EEGLAB analysis.",
                "https://www.linkedin.com/in/eva-sarin-9babb0166"));


        memberChapter.add(new TeamFragModelClass("Aakriti Jain","Vice-Chairperson, WIE",R.drawable.aakritijain,
                "I am an enthusiastic learner, love to grab new opportunities and take lead from the front. " +
                "Managing the team and events. I've always been inclined towards the managerial stuff. I have started exploring the technical side too,  with ML and Web Design",
                "https://www.linkedin.com/in/aakriti-jain-9618861a7"));


        memberChapter.add(new TeamFragModelClass("Keya Deshmukh","Vice-Chairperson, WIE",R.drawable.keyadeshmukh,
                "A keen learner and always want to explore things. Domain of Work: Machine Learning and Graphic Designing",
                "https://www.linkedin.com/in/keya-deshmukh-4888721a7"));


        memberChapter.add(new TeamFragModelClass("Tanya Mahajan","Secretary, WIE",R.drawable.tanyamahajan,
                "I like to do coding and I am fond of series and listening to music.","https://www.linkedin.com/in/tanya-mahajan-a19a81182"));

        memberChapter.add(new TeamFragModelClass("Astha Chabra", "WIE STAR(Student Teacher and Research) Coordinator",R.drawable.asthachhabra,
                "An enthusiastic person eager to contribute to team success through hard work, attention to go in detail and organisational skills. Motivated to learn,grow and excel professionally." +
                "More inclined towards technical side rather than management side.","http://linkedin.com/in/astha-chhabra-20a20"));


        memberChapter.add(new TeamFragModelClass("Nikita Tewary","WIE Representative",R.drawable.nikitatewary,
                "I am hardworking and determined. Representing and helping WIE grow.","https://www.linkedin.com/in/nikita-tewary-791b461a5"));

        WIERecyclerView=findViewById(R.id.rvWIE);
        RecyclerViewAdapterCSTeam recyclerViewAdapter=new RecyclerViewAdapterCSTeam(this,memberChapter);
        WIERecyclerView.setAdapter(recyclerViewAdapter);
        WIERecyclerView.invalidate();
        WIERecyclerView.setLayoutManager(new LinearLayoutManager(this));
        WIERecyclerView.setItemViewCacheSize(100);
        WIERecyclerView.setDrawingCacheEnabled(true);
        WIERecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        WIERecyclerView.setNestedScrollingEnabled(false);
    }
}

package com.bvpieee.ui.teams;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bvpieee.R;

import java.util.ArrayList;
import java.util.List;

public class IAS_Team extends AppCompatActivity {

    private RecyclerView IASRecyclerView;
    private List<TeamFragModelClass> memberChapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ias_team);


        memberChapter= new ArrayList<>();
        memberChapter.add(new TeamFragModelClass("Sanjana Deswal","Chairperson, IAS",R.drawable.sanjanadeswal,"I am always curious to work and try something new. Domain o f Work: Non-Tech"));
        memberChapter.add(new TeamFragModelClass("Bhavya Wahie", "Secretary, IAS",R.drawable.bvpieee,"Video editor,Managing the Industrial Automation Society events"));
        memberChapter.add(new TeamFragModelClass("Aniket Aggarwal","Event Management Head, IAS",R.drawable.bvpieee,"My job is is to manage all the workshops and events taking place in IAS."));
        memberChapter.add(new TeamFragModelClass("Astha Chhabra","Head Public Relations, IAS",R.drawable.asthachhabra,"An enthusiastic person eager to contribute to the team through hard work, attention to go in detail and organisational skills. Motivated to learn, grow, and excel professionally." +
                "More inclines on the technical side rather than management side."));
        memberChapter.add(new TeamFragModelClass("Naman Aggarwal","Head Industrial Relations, IAS",R.drawable.namanaggarwal,"An avid Tech geek and startup enthusiast. Securing sponsorships and maintaining good public and industrial relations."));
        memberChapter.add(new TeamFragModelClass("Komal Singal","Publication and Documentation Head, IAS",R.drawable.komalsingal,"I like making dynamic websites, involved in art and craft activities, and coding. Full stack web developer| Java Programming | Python Programming | C Programming"));
        memberChapter.add(new TeamFragModelClass("Palvika","Creativity Head, IAS",R.drawable.palvikagoyal,"I love to code and learn new skills. Also, always ready to do some creative stuff. Web Development enthusiast with knowledge of PHP, C Programming and Python Programming."));
        memberChapter.add(new TeamFragModelClass("Shivam Jain","Chapter Representative, IAS",R.drawable.shivamjain,"I have a keen interest in coding and is happy to help anytime. Currently I am working in Front end Web Development."));
        memberChapter.add(new TeamFragModelClass("Amol Puri","Chapter Representative, IAS",R.drawable.amolpuri,"Want to learn new things, expand network and gain experience. I work as Publication and Documentation Head and currently I am working on C++."));

        IASRecyclerView=findViewById(R.id.rvIAS);
        RecyclerViewAdapterCSTeam recyclerViewAdapter= new RecyclerViewAdapterCSTeam(this,memberChapter);
        IASRecyclerView.setAdapter(recyclerViewAdapter);
        IASRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

}

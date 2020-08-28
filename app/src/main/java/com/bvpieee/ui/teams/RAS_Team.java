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

public class RAS_Team extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private List<TeamFragModelClass> memberChapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ras_team);

        memberChapter = new ArrayList<>();
        memberChapter.add(new TeamFragModelClass("Shashwat Panday","Chairperson, BVPIEEE RAS",R.drawable.shashwatpandey,
                "I have worked in Data Science and now exploring ROS, improving my Robotics skills. \nDomain of Work: Data Science and Computer Vision",
                "https://www.linkedin.com/in/shaxpy28"));


        memberChapter.add(new TeamFragModelClass("Kunal Gupta","Vice Chairperson,RAS ",R.drawable.kunalgupta,"Keen and Inquisitive Learner.\n " +
                "Domain of Work : Embedded Systems,IOT , Firmwa programming , Product Development","https://www.linkedin.com/in/kunal-gupta-98b27b9a/"));


        memberChapter.add(new TeamFragModelClass("Amitav Mitra","Research and Development Head, RAS",R.drawable.amitavmitra,"Loves robotics and gaming. \n" +
                "Doamin of Work: Robotics, 3d printing and deep learning","https://www.linkedin.com/in/amitav-mitra"));


        memberChapter.add(new TeamFragModelClass("Jayesh Goyal","Head- Event Management, RAS",R.drawable.jayeshgoyal,
                "I am an avid and quick learner who has work experience in leading small teams in hardware oriented projects. \n" +
                "I love to work in hardware based projects like making drones and robots with different functioning and movements",
                "https://www.linkedin.com/in/jayesh-goyal-a48b1919b"));


        memberChapter.add(new TeamFragModelClass("Shantanu Sharma","Head- Event Management, RAS",R.drawable.shantanusharma,
                "I am a AI and Robotics enthusiast. I am a good observer and crazy about sci-fi and astrophysics.\n" +
                "Domain of work : AI and robotics","https://www.linkedin.com/in/shantanu-sharma-bba9a61a2"));


        memberChapter.add(new TeamFragModelClass("Saurav Pandey","Head- Publication and Documentation,RAS",R.drawable.sauravpandey,
                "An inquisitive learner who wants to explore new things and develop new things that can make a holistic social impact.\n" +
                "Domain of Work: Robotics and ML","https://www.linkedin.com/in/saurav-pandey-095112196"));


        memberChapter.add(new TeamFragModelClass("Harshendra Singh","Head- Creativity, RAS",R.drawable.harshendrasingh,
                "I like to take up new challenges and explore new ideas.\n" +
                "Responsible for designing and promoting RAS events and other activities.","https://www.linkedin.com/harsh735"));


        memberChapter.add(new TeamFragModelClass("Mishael Thomas","Chapter Representative, RAS",R.drawable.mishaelthomas,
                "I am modest, but hard working and I consistently sets firm goals for myself. \n" +
                "I an very much interested in Robotics especially implementing the concepts of Computer Vision through it.","https://www.linkedin.com/in/mishaelthomas1482"));


        memberChapter.add(new TeamFragModelClass("Riya Sharma","Chapter Representative, RAS",R.drawable.riyasharma,
                "Introvert and inquisitive.\n Domain of Work: Python, Machine Learning.","https://www.linkedin.com/in/riya-sharma-399365191"));


        memberChapter.add(new TeamFragModelClass("Siddhant Jha","Chapter Representative, RAS",R.drawable.siddhantjha,
                "I am a hardworking person who thrives for betterment and also keen to explore new things.\n" +
                "Currently learning MATLAB and Machine learning.","https://www.linkedin.com/in/siddhant-jha-8a9366191/"));


        myRecyclerView=findViewById(R.id.rvRAS);
        RecyclerViewAdapterCSTeam recyclerViewAdapter=new RecyclerViewAdapterCSTeam(this,memberChapter);
        myRecyclerView.setAdapter(recyclerViewAdapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setItemViewCacheSize(50);
        myRecyclerView.setDrawingCacheEnabled(true);
        myRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        myRecyclerView.setNestedScrollingEnabled(false);

    }

}

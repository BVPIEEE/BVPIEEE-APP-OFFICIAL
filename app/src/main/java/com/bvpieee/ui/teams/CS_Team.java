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

public class CS_Team extends AppCompatActivity {

    private RecyclerView CSRecyclerView;
    private List<TeamFragModelClass> memberChapterCS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_team);

        memberChapterCS = new ArrayList<>();

        memberChapterCS.add(new TeamFragModelClass("Tanishq Sehgal", "Chairperson, CS", R.drawable.tanishqsehghal,
                "Diligent Learner. Technology Enthusiast. Experienced in working in a team. I believe consistency is the key!\n" +
                        "Domain of Work: Android App Development.", "https://www.linkedin.com/in/tanishq-sehgal-a86bbb184/", "ECE, 3rd Year"));


        memberChapterCS.add(new TeamFragModelClass("Saksham Pruthi", "Vice -Chairperson, CS", R.drawable.sakshampruthi,
                "Things aren't always #000000 and #FFFFFF.\nCo-Founder: College Connect.\n" +
                        "Love to Explore new Tech. Love to Code and innovate\nDomain of Work: Android App Development.",
                "https://linkedin.com/in/sakshampruthi", "ECE, 3rd Year"));


        memberChapterCS.add(new TeamFragModelClass("Harshit Gaur", "Secretary, CS", R.drawable.harshitgaur,
                "Believes in innovation at it's core. Dreamer and aspiring engineer\n"
                        + "Domain of Work: Deep Learning App Development and AR/VR", "https://www.linkedin.com/in/harshitgaur2", "CSE, 3rd Year"));


        memberChapterCS.add(new TeamFragModelClass("Dharana", "Research and Development Head, CS", R.drawable.dharana,
                "Hi I am Dharana. Always the one looking to do something better. I work in the field of Data Science",
                "https://www.linkedin.com/mwlite/in/dharana-b90b2617b",
                "CSE, 3rd Year"));


        memberChapterCS.add(new TeamFragModelClass("Ravneet Singh", "Research and Development Heas, CS", R.drawable.ravneetsingh,
                "Ability to build sincerity and trust; moderate behaviours(less impulsive) and enhance agreeableness\n" +
                        "Skilled in network infrastructure, Experienced in troubleshooting CISCO devices as a network administrator.",
                "https://www.linkedin.com/in/ravneet-kumar-72a650140", "ECE, 3rd Year"));


        memberChapterCS.add(new TeamFragModelClass("Kunal Aggarwal", "Event Management Head, CS", R.drawable.kunalaggarwal,
                "I am a programming enthusiast. I am good at many programming languages. My work is to arrange and manage the workshop and events at Computer Society",
                "http://linkedin.com/in/kunal-aggarwal-8367121a2", "EEE, 2nd Year"));


        memberChapterCS.add(new TeamFragModelClass("Shubham Kumar", "Creativity Head, CS", R.drawable.shubhamkumar,
                "I am a creative being who is eager to learn new things. Domain of Work: Android App Development",
                "https://www.linkedin.com/in/shubham-kumar-707a94194/", "ECE, 3rd Year"));


        memberChapterCS.add(new TeamFragModelClass("Rohit Khushwaha", "Chapter Representative, CS", R.drawable.rohitkhushwaha,
                "I'm a technology enthusiast, love to face challenges,always try to push my limits,and I believe to find a bteer version of yourself. " +
                        "Experience and exposure are the two keys which are necessary", "https://www.linkedin.com/in/rohit-kushwaha-66a678193", "ECE, 3rd Year"));

        CSRecyclerView = findViewById(R.id.rvCS);
        RecyclerViewAdapterCSTeam recyclerViewAdapter = new RecyclerViewAdapterCSTeam(this, memberChapterCS);
        CSRecyclerView.setAdapter(recyclerViewAdapter);
        CSRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        CSRecyclerView.setItemViewCacheSize(20);
        CSRecyclerView.setDrawingCacheEnabled(true);
        CSRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

    }

}

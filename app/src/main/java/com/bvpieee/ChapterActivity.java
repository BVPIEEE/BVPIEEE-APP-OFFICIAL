package com.bvpieee;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.bvpieee.ui.chapters.SectionsPagerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChapterActivity extends AppCompatActivity {

    public static final String CHAPTER = "ChapterNumber";
    public static final String Coverflow = "CoverFlow";
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference;
    ArrayList<String> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        //Setup viewpager and tablayout
        SectionsPagerAdapter sectionsPagerAdapter;
        Intent intent = getIntent();
        int chapno = intent.getIntExtra(CHAPTER,0);
        String coverflow = intent.getStringExtra(Coverflow);
        if (coverflow == null)

            sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), "chapter");
        else
            sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), "sig");
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


//        Toast.makeText(this, chapno+"", Toast.LENGTH_SHORT).show();
        viewPager.setCurrentItem(chapno);
    }

}
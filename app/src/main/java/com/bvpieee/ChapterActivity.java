package com.bvpieee;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bvpieee.ui.chapters.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ChapterActivity extends AppCompatActivity {

    public static final String CHAPTER = "ChapterNumber";
    public static final String Coverflow = "CoverFlow";
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

            sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),this, "chapter");
        else
            sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),this, "sig");
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


//        Toast.makeText(this, chapno+"", Toast.LENGTH_SHORT).show();
        viewPager.setCurrentItem(chapno);
    }

}
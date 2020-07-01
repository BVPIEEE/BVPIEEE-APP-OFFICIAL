package com.bvpieee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.bvpieee.ui.chapters.SectionsPagerAdapter;

public class ChapterActivity extends AppCompatActivity {

    public static final String CHAPTER = "ChapterNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        //Setup viewpager and tablayout
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        Intent intent = getIntent();
        int chapno = intent.getIntExtra(CHAPTER,0);
        Toast.makeText(this, chapno+"", Toast.LENGTH_SHORT).show();
        viewPager.setCurrentItem(chapno);
    }
}
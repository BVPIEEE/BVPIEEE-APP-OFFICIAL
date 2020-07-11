package com.bvpieee.ui.home;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bvpieee.Chapter;
import com.bvpieee.adapters.CoverFlowAdapter;
import com.bvpieee.HomeActivity;
import com.bvpieee.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CoverFlowAdapter adapter, sigsAdapter;
    private ArrayList chapters, sigs;
    private Context context;
    BottomNavigationView bottomNavigationView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if(getActivity()!=null)
            bottomNavigationView = getActivity().findViewById(R.id.nav_view);

        homeViewModel =
                 new ViewModelProvider(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, null);


        //Chapters Coverflow
        FeatureCoverFlow coverFlow = null;
        coverFlow = root.findViewById(R.id.chapterCoverflow);
        initalizeCoverFlow();
        adapter = new CoverFlowAdapter(context, chapters);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(this.onScrollListener());

        //Sigs Coverflow
        FeatureCoverFlow coverFlow2 = null;
        coverFlow2 = root.findViewById(R.id.sigsCoverflow);
        initalizeCoverFlow2();
        sigsAdapter = new CoverFlowAdapter(context, sigs);
        coverFlow2.setAdapter(sigsAdapter);
        coverFlow2.setOnScrollPositionListener(this.onScrollListener());

        return root;
    }

    public void initalizeCoverFlow() {
        chapters = new ArrayList<>();
        chapters.add(new Chapter(R.drawable.raspp, "RAS"));
        chapters.add(new Chapter(R.drawable.cspp, "CS"));
        chapters.add(new Chapter(R.drawable.iaspp, "IAS"));
        chapters.add(new Chapter(R.drawable.wiepp, "WIE"));
        chapters.add(new Chapter(R.drawable.hknpp, "HKN"));

    }

    public void initalizeCoverFlow2() {
        sigs = new ArrayList<>();
        sigs.add(new Chapter(R.drawable.codex, "CODE-X"));
        sigs.add(new Chapter(R.drawable.drishti, "DRISHTI"));
        sigs.add(new Chapter(R.drawable.robotics, "ROBOTICS & AUTOMATION UNITED"));
        sigs.add(new Chapter(R.drawable.quiz, "BVCOE QUIZ CLUB"));
        sigs.add(new Chapter(R.drawable.entrepr, "ENTREPRENEURSHIP CELL"));
        sigs.add(new Chapter(R.drawable.gamma, "GAMMA"));

    }

    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        bottomNavigationView.getMenu().findItem(R.id.navigation_home).setChecked(true);
    }
    @Override
    public void onResume() {
        super.onResume();
        bottomNavigationView.getMenu().findItem(R.id.navigation_home).setChecked(true);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context= context;
    }
}

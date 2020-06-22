package com.bvpieee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class Main2Activity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener{

    private CoverFlowAdapter adapter, sigsAdapter;
    private ArrayList chapters, sigs;
    private SliderLayout mDemoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cahpters Coverflow
        FeatureCoverFlow coverFlow = null;
        coverFlow = findViewById(R.id.chapterCoverflow);
        initalizeCoverFlow();
        adapter = new CoverFlowAdapter(this, chapters);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(this.onScrollListener());

        //Sigs Coverflow
        FeatureCoverFlow coverFlow2 = null;
        coverFlow2 = findViewById(R.id.sigsCoverflow);
        initalizeCoverFlow2();
        sigsAdapter = new CoverFlowAdapter(this, chapters);
        coverFlow2.setAdapter(sigsAdapter);
        coverFlow2.setOnScrollPositionListener(this.onScrollListener());

    }

    private void initalizeCoverFlow() {
        chapters = new ArrayList<>();
        chapters.add(new Chapter(R.drawable.raspp, "RAS"));
        chapters.add(new Chapter(R.drawable.cspp, "CS"));
        chapters.add(new Chapter(R.drawable.iaspp, "IAS"));

    }

    private void initalizeCoverFlow2() {
        sigs = new ArrayList<>();
        sigs.add(new Chapter(R.drawable.raspp, "RAS"));
        sigs.add(new Chapter(R.drawable.cspp, "CS"));
        sigs.add(new Chapter(R.drawable.iaspp, "IAS"));

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
    public void onSliderClick(BaseSliderView slider) {

    }
}

package com.bvpieee.ui.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bvpieee.Chapter;
import com.bvpieee.R;
import com.bvpieee.adapters.CoverFlowAdapter;
import com.bvpieee.adapters.SigAdapter;
import com.bvpieee.models.EventInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CoverFlowAdapter adapter;
    private SigAdapter sigsAdapter;
    private ArrayList chapters, sigs;
    private Context context;
    FeatureCoverFlow coverFlow, coverFlow2;
    ChipNavigationBar bottomNavigationView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference mDatabaseReference;
    ValueEventListener listener;
    EasyFlipView easyflipview;
    TextView topic, topicBack, dateText, venue;
    String url;
    Button registerButton;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (getActivity() != null)
            bottomNavigationView = getActivity().findViewById(R.id.bottom_nav);

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        coverFlow = root.findViewById(R.id.chapterCoverflow);
        coverFlow2 = root.findViewById(R.id.sigsCoverflow);
        easyflipview = root.findViewById(R.id.easyflip);
        topic = root.findViewById(R.id.topic);
        topicBack = root.findViewById(R.id.topicBack);
        dateText = root.findViewById(R.id.dateandtime);
        venue = root.findViewById(R.id.venue);
        registerButton = root.findViewById(R.id.quickRegister);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Chapters Coverflow
        initalizeCoverFlow();
        adapter = new CoverFlowAdapter(context, chapters);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(this.onScrollListener());

        //Sigs Coverflow
        initalizeCoverFlow2();
        sigsAdapter = new SigAdapter(context, sigs);
        coverFlow2.setAdapter(sigsAdapter);
        coverFlow2.setOnScrollPositionListener(this.onScrollListener());


        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = firebaseDatabase.getReference("Events");
        mDatabaseReference.keepSynced(true);
        mDatabaseReference.orderByChild("date").addListenerForSingleValueEvent(listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    for (DataSnapshot postDataSnapshot : snapshot.getChildren()) {
                        EventInfo event = postDataSnapshot.getValue(EventInfo.class);
                        topic.setText(event.getName());
                        topicBack.setText(event.getName());
                        dateText.setText(date(event.getDate()));
                        venue.setText(event.getVenue());
                        url = event.getUrl();
                        break;
                    }
                } catch (Exception e) {
                    topic.setText("No Event");
                    topicBack.setText("No Event");
                    dateText.setText("");
                    venue.setText("");
                    Log.d("HomeFragment", "onDataChange: "+e.getMessage());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        registerButton.setOnClickListener(view -> {
            if (url != null) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setColorScheme(context.getColor(R.color.BottomNavBg));
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(context, Uri.parse(url));
            }
        });

    }

    public void initalizeCoverFlow() {
        chapters = new ArrayList<Chapter>();
        chapters.add(new Chapter(R.drawable.raspp, "RAS"));
        chapters.add(new Chapter(R.drawable.cspp, "CS"));
        chapters.add(new Chapter(R.drawable.iaspp, "IAS"));
        chapters.add(new Chapter(R.drawable.wiepp, "WIE"));
        chapters.add(new Chapter(R.drawable.hknpp, "HKN"));

    }

    public void initalizeCoverFlow2() {
        sigs = new ArrayList<Chapter>();
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
    public String date(String date) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat("EEE, dd MMM yy",Locale.getDefault());
        Date datetext;
        String str = null;

        try {
            datetext = inputFormat.parse(date);
            assert datetext != null;
            str = outputFormat.format(datetext);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }


    @Override
    public void onStart() {
        super.onStart();
//        bottomNavigationView.getMenu().findItem(R.id.navigation_home).setChecked(true);
        bottomNavigationView.setItemSelected(R.id.navigation_home, true);
    }

    @Override
    public void onResume() {
        super.onResume();
//        bottomNavigationView.getMenu().findItem(R.id.navigation_home).setChecked(true);
        bottomNavigationView.setItemSelected(R.id.navigation_home, true);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (listener != null)
            mDatabaseReference.removeEventListener(listener);
    }
}

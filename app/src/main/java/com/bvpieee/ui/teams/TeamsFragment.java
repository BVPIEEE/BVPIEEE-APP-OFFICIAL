package com.bvpieee.ui.teams;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.bvpieee.R;
import com.google.android.material.tabs.TabLayout;

public class TeamsFragment extends Fragment {

//    private TeamsViewModel notificationsViewModel;
    View teamFragment;
    ViewPager viewPager;
    TabLayout tabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        notificationsViewModel =
//                new ViewModelProvider(this).get(TeamsViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_teams, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
        teamFragment=inflater.inflate(R.layout.fragment_teams,container,false);
        viewPager=teamFragment.findViewById(R.id.teamPager);
        tabLayout=teamFragment.findViewById(R.id.tabLayoutTeams);
        return teamFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ViewPagerSetup(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void ViewPagerSetup(ViewPager viewPager) {

        SectionPageAdapterTeams adapterTeams= new SectionPageAdapterTeams(getChildFragmentManager());
        adapterTeams.addFragment(new CoreTemFragment(),"CORE TEAM");
        adapterTeams.addFragment(new ChapterTeamFragment(),"CHAPTER TEAM");
        adapterTeams.addFragment(new SigsTeamFragment(),"SIG TEAM");
        adapterTeams.addFragment(new AuxillaryTeamFragment(),"AUXILLARY TEAM");

        viewPager.setAdapter(adapterTeams);
    }


}

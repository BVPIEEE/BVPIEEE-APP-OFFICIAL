package com.bvpieee.ui.teams;

import android.animation.Animator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;
import com.bvpieee.R;
import com.google.android.material.tabs.TabLayout;

public class TeamsFragment extends Fragment {

//    private TeamsViewModel notificationsViewModel;
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;
    View layout, teams;
    LottieAnimationView animationView;
    String team_chap=null;
//    private RecyclerView myRecyclerView;
//    private List<CoreTeamModel> memberCore;

    public TeamsFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            Bundle arguments = getArguments();
            team_chap = arguments.getString("TEAMS");
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_teams,container,false);
        viewPager= view.findViewById(R.id.teamPager);
        tabLayout=view.findViewById(R.id.tabLayoutTeams);
        layout = view.findViewById(R.id.lottie_layer);
        teams = view.findViewById(R.id.teams_linear);
        teams.setVisibility(View.INVISIBLE);
        animationView = view.findViewById(R.id.team);
        animationView.setSpeed(2.0F);
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                teams.setVisibility(View.VISIBLE);
                layout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        return view;
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
        adapterTeams.addFragment(new CoreTemFragment(),"Core Team");
        adapterTeams.addFragment(new ChapterTeamFragment(),"Chapters");
        adapterTeams.addFragment(new SigsTeamFragment(),"SIGs");
        adapterTeams.addFragment(new AuxillaryTeamFragment(),"Auxillary Team");

        viewPager.setAdapter(adapterTeams);
        if(team_chap!=null) {
            if (team_chap.equals("chapter"))
                viewPager.setCurrentItem(1);
            else if (team_chap.equals("sig"))
                viewPager.setCurrentItem(2);
        }
    }
}

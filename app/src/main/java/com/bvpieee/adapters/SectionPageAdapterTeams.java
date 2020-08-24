package com.bvpieee.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionPageAdapterTeams extends FragmentPagerAdapter {

    private List<Fragment> teamFraglist=new ArrayList<>();
    private List<String> teamFragTitle= new ArrayList<>();

    public SectionPageAdapterTeams(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return teamFraglist.get(position);
    }

    @Override
    public int getCount() {
        return teamFraglist.size();
    }

    public CharSequence getPageTitle(int position){
        return teamFragTitle.get(position);
    }

    public void addFragment(Fragment fragment,String title){
        teamFraglist.add(fragment);
        teamFragTitle.add(title);
    }
}

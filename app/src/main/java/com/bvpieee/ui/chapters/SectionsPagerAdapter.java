package com.bvpieee.ui.chapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bvpieee.R;
import com.bvpieee.ui.events.EventsFragment;
import com.bvpieee.ui.home.HomeFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    public static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_3, R.string.tab_text_2, R.string.tab_text_4, R.string.tab_text_5};
    public static final int[] SIG_TAB_TITLES = new int[]{R.string.tab_text_6, R.string.tab_text_7, R.string.tab_text_8, R.string.tab_text_9, R.string.tab_text_10, R.string.tab_text_11};
    private final Context mContext;
    private final String Chapter;

    public SectionsPagerAdapter(Context context, FragmentManager fm, String chapter) {
        super(fm);
        this.Chapter = chapter;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return new PlaceholderFragment(position,Chapter);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (Chapter.equals("chapter"))
            return mContext.getResources().getString(TAB_TITLES[position]);
        return mContext.getResources().getString(SIG_TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 5 total pages.
        if (Chapter.equals("chapter"))
            return 5;
        return 6;
    }
}
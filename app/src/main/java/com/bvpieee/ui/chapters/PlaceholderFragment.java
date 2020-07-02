package com.bvpieee.ui.chapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bvpieee.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private int position;
    private ImageView imageView;
    private TextView title;
    private RelativeLayout social, white, socialExpanded;
    private int[] imageResource = {R.drawable.raspp, R.drawable.iaspp, R.drawable.cspp, R.drawable.wiepp, R.drawable.hknpp};
    private String[] titles = {"RAS", "IAS", "CS", "WIE", "HKN"};

    public PlaceholderFragment(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_chapter, container, false);

        imageView = root.findViewById(R.id.chapterBanner);
        title = root.findViewById(R.id.textView2);
        social = root.findViewById(R.id.socialLayout);
        socialExpanded = root.findViewById(R.id.socialLayoutExpanded);
//        white = root.findViewById(R.id.whiteBack);

        title.setText(titles[position]);
        imageView.setImageResource(imageResource[position]);
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                white.setVisibility(View.VISIBLE);
                socialExpanded.setVisibility(View.VISIBLE);
            }
        });

        return root;
    }
}
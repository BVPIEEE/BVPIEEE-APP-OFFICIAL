package com.bvpieee.ui.chapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private int[] imageResource = {R.drawable.raspp, R.drawable.iaspp, R.drawable.cspp, R.drawable.wiepp, R.drawable.hknpp};

    public PlaceholderFragment(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_chapter, container, false);

        imageView = root.findViewById(R.id.chapterBanner);
        imageView.setImageResource(imageResource[position]);

        return root;
    }
}
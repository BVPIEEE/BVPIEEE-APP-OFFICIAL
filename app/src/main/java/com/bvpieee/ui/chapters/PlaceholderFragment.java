package com.bvpieee.ui.chapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.bvpieee.HomeActivity;
import com.bvpieee.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import static com.bvpieee.ui.chapters.SectionsPagerAdapter.SIG_TAB_TITLES;
import static com.bvpieee.ui.chapters.SectionsPagerAdapter.TAB_TITLES;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private int position;
    private String chapter;
    private ImageView imageView;
    private TextView title, placeholder;
    private CardView social, socialExpanded, aboutLayout,  eventLayout;
    private RelativeLayout white;
    private Button close;
    private int[] imageResource = {R.drawable.raspp, R.drawable.cspp, R.drawable.iaspp, R.drawable.wiepp, R.drawable.hknpp};
    private int[] sigImageResource = {R.drawable.codex, R.drawable.drishti, R.drawable.robotics, R.drawable.quiz, R.drawable.entrepr, R.drawable.gamma};
    Context context;
   String[] arrayList;
//    private String[] titles = {"RAS", "IAS", "CS", "WIE", "HKN"};

    public PlaceholderFragment(int position, String chapter) {
        this.position = position;
        this.chapter = chapter;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View root;
        if (chapter.equals("chapter"))
            root = inflater.inflate(R.layout.fragment_chapter, container, false);
        else
            root = inflater.inflate(R.layout.fragment_sig, container, false);
        arrayList = context.getResources().getStringArray(R.array.chapter_description);

        eventLayout = root.findViewById(R.id.eventsLayout);
        imageView = root.findViewById(R.id.chapterBanner);
        title = root.findViewById(R.id.textView2);
        social = root.findViewById(R.id.socialLayout);
        socialExpanded = root.findViewById(R.id.socialLayoutExpanded);
        close = root.findViewById(R.id.close);
        aboutLayout = root.findViewById(R.id.aboutLayout);
//        white = root.findViewById(R.id.whiteBack);

       final AlertDialog.Builder builder = new MaterialAlertDialogBuilder(context);

        if (chapter.equals("chapter")) {
            title.setText(TAB_TITLES[position]);
            imageView.setImageResource(imageResource[position]);
        }
        else {
            title.setText(SIG_TAB_TITLES[position]);
            imageView.setImageResource(sigImageResource[position]);
        }
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                white.setVisibility(View.VISIBLE);
                socialExpanded.setVisibility(View.VISIBLE);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        socialExpanded.setVisibility(View.GONE);
//                        white.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        aboutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = ((AppCompatActivity) context).getLayoutInflater();
                View view = inflater.inflate(R.layout.about_dialog, null);
                builder.setView(view);
                close = view.findViewById(R.id.close_dialog_button);
                placeholder = view.findViewById(R.id.placeHolder);
                placeholder.setText(arrayList[position]);
                final AlertDialog dialog = builder.create();
                dialog.show();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

        eventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, HomeActivity.class).putExtra("FRAG","event"));
            }
        });

        return root;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
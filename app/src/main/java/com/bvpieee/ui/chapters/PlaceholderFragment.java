package com.bvpieee.ui.chapters;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private CardView social, socialExpanded, aboutLayout, eventLayout, teamLayout;
    private RelativeLayout white;
    ImageButton instagram, facebook, website;
    private Button close;
    private int[] imageResource = {R.drawable.raspp, R.drawable.cspp, R.drawable.iaspp, R.drawable.wiepp, R.drawable.hknpp};
    private int[] sigImageResource = {R.drawable.codex, R.drawable.drishti, R.drawable.robotics, R.drawable.quiz, R.drawable.entrepr, R.drawable.gamma};
    private String[] fbIds;
    private String[] websites;
    Context context;
    String[] arrayList;
    String team;
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
        if (chapter.equals("chapter")) {
            team = "chapter";
            root = inflater.inflate(R.layout.fragment_chapter1, container, false);
            arrayList = context.getResources().getStringArray(R.array.chapter_description);
            fbIds = new String[]{"357306677679810", "1201811083175429", "483730548444337", "266525677321638", "125463600824133"};
            websites = new String[]{"https://bvpieeend.com/pages/societies_chapters.html", "https://bvpieeend.com/pages/societies_chapters.html", "https://bvpieeend.com/pages/societies_chapters.html", "https://bvpieeend.com/pages/wie.html", "https://bvpieeend.com/pages/societies_chapters.html"};
        } else {
            team = "sig";
            root = inflater.inflate(R.layout.fragment_sig1, container, false);
            arrayList = context.getResources().getStringArray(R.array.sig_description);
            fbIds = new String[]{"125463600824133", "125463600824133", "125463600824133", "125463600824133", "125463600824133"};
            websites = new String[]{"https://bvpieeend.com/pages/sigs.html", "https://bvpieeend.com/pages/sigs.html", "https://bvpieeend.com/pages/sigs.html", "https://bvpieeend.com/pages/sigs.html", "https://bvpieeend.com/pages/sigs.html"};
        }

        eventLayout = root.findViewById(R.id.eventsLayout);
        imageView = root.findViewById(R.id.chapterBanner);
        title = root.findViewById(R.id.textView2);
        social = root.findViewById(R.id.socialLayout);
//        socialExpanded = root.findViewById(R.id.socialLayoutExpanded);
//        close = root.findViewById(R.id.close);
        instagram = root.findViewById(R.id.instagram);
        facebook = root.findViewById(R.id.facebook);
        website = root.findViewById(R.id.website);
        aboutLayout = root.findViewById(R.id.aboutLayout);
        teamLayout = root.findViewById(R.id.teamLayout);

//        white = root.findViewById(R.id.whiteBack);


        return root;
    }

    public static Intent newFacebookIntent(PackageManager pm, String url) {
        Uri uri = Uri.parse(url);
        try {
            Log.d("PlaceholderFragment", "newFacebookIntent: facebook intent called");
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                uri = Uri.parse("fb://page/" + url);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
            uri = Uri.parse("https://www.facebook.com/" + url);
        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }

    public void instagram() {
        Uri uri = Uri.parse("http://instagram.com/_u/bvpieee");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");
        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/bvpieee")));
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final AlertDialog.Builder builder = new MaterialAlertDialogBuilder(context);

        if (chapter.equals("chapter")) {
            title.setText(TAB_TITLES[position]);
            imageView.setImageResource(imageResource[position]);
        } else {
            title.setText(SIG_TAB_TITLES[position]);
            imageView.setImageResource(sigImageResource[position]);
        }
        facebook.setOnClickListener(v -> {
            Log.d("PlaceholderFragment", "onClick: facebook call");
            startActivity(newFacebookIntent(context.getPackageManager(), fbIds[position]));
        });

        instagram.setOnClickListener(v -> instagram());
        website.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websites[position]));
            startActivity(intent);
        });
        aboutLayout.setOnClickListener(v -> {
            LayoutInflater inflater = ((AppCompatActivity) context).getLayoutInflater();
            View view = inflater.inflate(R.layout.about_dialog, null);
            builder.setView(view);
            close = view.findViewById(R.id.close_dialog_button);
            placeholder = view.findViewById(R.id.placeHolder);
            placeholder.setText(arrayList[position]);
            final AlertDialog dialog = builder.create();
            dialog.show();
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            close.setOnClickListener(v1 -> dialog.dismiss());
        });

        eventLayout.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("FRAG", "event");
            bundle.putString("TEAM", title.getText().toString());
            Intent intent = new Intent(context, HomeActivity.class);
            intent.putExtras(bundle);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            Activity activity = (Activity) context;
            activity.finish();
        });

        teamLayout.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("FRAG", "teams");
            bundle.putString("CHAP", team);
            Intent intent = new Intent(context, HomeActivity.class);
            intent.putExtras(bundle);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            Activity activity = (Activity) context;
            activity.finish();
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
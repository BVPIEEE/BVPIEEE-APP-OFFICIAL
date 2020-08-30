package com.bvpieee.ui.teams;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bvpieee.R;
import com.bvpieee.adapters.RecyclerViewAdapterSigs;
import com.bvpieee.models.TeamFragModelClass;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SigsTeamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SigsTeamFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View view;
    private RecyclerView myRecyclerView;
    private List<TeamFragModelClass> memberSigs;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SigsTeamFragment() {
        // Required empty public constructor
    }


    public static SigsTeamFragment newInstance(String param1, String param2) {
        SigsTeamFragment fragment = new SigsTeamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        memberSigs = new ArrayList<>();

        memberSigs.add(new TeamFragModelClass("Shubham Kumar", "Head Supervisor, Drishti", R.drawable.shubhamkumar,
                "I'm a creative being who is eager to learn new things." +
                        "Android Application Developmemt is my domain of work", "https://www.linkedin.com/in/shubham-kumar-707a94194/", "ECE, 2nd Year"));


        memberSigs.add(new TeamFragModelClass("Shreyas Grupta", "Executive, Drishti", R.drawable.bvpieee, "No Info Available", "https://www.linkedin.com/",
                "No Info Available"));


        memberSigs.add(new TeamFragModelClass("Bhavya Wahie", "Executive, Drishti", R.drawable.bvpieee,
                "No Info Available", "https://www.linkedin.com/", "No Info Available"));


        memberSigs.add(new TeamFragModelClass("Archit Kumar", "Head Supervisor, Entreprenureship Cell", R.drawable.architkumar,
                "I'm analytical in nature, which perceives that I love solving problems. " +
                        "In my opinion, an engineering degree is worth nothing if it  can't contribute to our daily problems." +
                        "Apart from that, I'm a proven communicator i.e a very patient listener and a keen observer. " +
                        "Our division, Entrepreneurship cell would work more towards being a startup incubator in order to nurture upcoming ideas and shape them into a venture. " +
                        "We also aim to instill an entrepreneur like mindset in students through various activities and opportunities.", "http://linkedin.com/in/archit-kumar-26455a1a7",
                "ECE, 2nd Year"));


        memberSigs.add(new TeamFragModelClass("Satvik Singh", "Head Supervisor, Gamma", R.drawable.satviksingh,
                "Creative and enthusiastic. I love to do anything related to video games. Even making them." +
                        "Hosting gaming events across the calendar and introducing Game Development to learners", "https://www.linkedin.com/in/satvik-singh-2345521a7/",
                "ECE, 2nd Year"));


        memberSigs.add(new TeamFragModelClass("Harshit Mathur", "Head Supervisor, BQC", R.drawable.harshitmathur,
                "I'm always curious and enthusiastic about learning and exploring new avenues." +
                        "Currently Programming and Quizzing with some past experience with Robotics and Automation.", "https://www.linkedin.com/in/harshit-mathur-26558a1a2", "IT, 2nd Year"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sigs_team, container, false);
        myRecyclerView = view.findViewById(R.id.rvSigs);
        RecyclerViewAdapterSigs recyclerViewAdapter = new RecyclerViewAdapterSigs(getContext(), memberSigs);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        myRecyclerView.setItemViewCacheSize(20);
        myRecyclerView.setDrawingCacheEnabled(true);
        myRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        return view;
    }


}
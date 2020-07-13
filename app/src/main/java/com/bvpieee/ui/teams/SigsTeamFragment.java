package com.bvpieee.ui.teams;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bvpieee.R;

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
        memberSigs.add(new TeamFragModelClass("Shubham Kumar","Head Supervisor, Drishti",R.drawable.bvpieee));
        memberSigs.add(new TeamFragModelClass("Shreyas Grupta", "Executive, Drishti", R.drawable.bvpieee));
        memberSigs.add(new TeamFragModelClass("Bhavya Wahie", "Executive, Drishti", R.drawable.bvpieee));
        memberSigs.add(new TeamFragModelClass("Archit Kumar", "Head Supervisor, Entreprenureship Cell", R.drawable.architkumar));
        memberSigs.add(new TeamFragModelClass("Satvik Singh", "Head Supervisor, Gamma", R.drawable.satviksingh));
        memberSigs.add(new TeamFragModelClass("Harshit Mathur", "Head Supervisor, BQC", R.drawable.harshitmathur));
        memberSigs.add(new TeamFragModelClass("Rishabh Singh", "Head Supervisor, Creators", R.drawable.bvpieee));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_sigs_team ,container,false);
        myRecyclerView =(RecyclerView) view.findViewById(R.id.rvSigs);
        RecyclerViewAdapterCoreTeam recyclerViewAdapter=new RecyclerViewAdapterCoreTeam(getContext(),memberSigs);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }



}
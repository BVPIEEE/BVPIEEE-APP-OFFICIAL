package com.bvpieee.ui.teams;

import android.os.Bundle;

import androidx.annotation.Nullable;
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
 * Use the {@link CoreTemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoreTemFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView myRecyclerView;
    View view;
    private List<TeamFragModelClass> memberCore;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CoreTemFragment() {
        // Required empty public constructor
    }

    public static CoreTemFragment newInstance(String param1, String param2) {
        CoreTemFragment fragment = new CoreTemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        memberCore= new ArrayList<>();
        memberCore.add(new TeamFragModelClass("Kshitij Sidana","Chairperson, BVPIEEE",R.drawable.kshitijsidana,
                "Fueled by fascination. Driven by logic. Jack of all but master of some.\n Domain of work : Robotics and Computer Vision"));
        memberCore.add(new TeamFragModelClass("Himani Negi","Vice Chairperson, BVPIEEE", R.drawable.himaninegi,"Hi, This is me, Himani Negi. Currently I am a student developer " +
                "in Google summer of code under redhenlab organization. I am working under Image and audio clustering project. Previosuly I was research intern in IIIT-D where I worked in analysing " +
                "the collusive behaviour in social networking site.Creating a world with innovative ideas is something a part of my vision and I never look back to put efforts for it."));
        memberCore.add(new TeamFragModelClass("Chetanya","General Secretary, BVPIEEE",R.drawable.chetanya,"Lead,Guidance,Mentor without a title is my philosophy. " +
                "Blockchain Application Researcher"));
        memberCore.add(new TeamFragModelClass("Sanjana Deswal","Chief Coordinator, BVPIEEE and IAS Chairperson",R.drawable.sanjanadeswal,"I am always curious to work and try something new." +
                "Firld of work: Non-Technical"));
        memberCore.add(new TeamFragModelClass("Aakriti Jain","Joint Secretary, BVPIEEE and WIE Vice Chairperon",R.drawable.aakritijain,"I am an enthusiastic learner, love to grab new opportunities and take lead from the front." +
                "I manage the team and events. I've always been inclined towards the managerial stuff. I have started exploring the technical side too, with ML and web design."));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_core_tem ,container,false);
        myRecyclerView =(RecyclerView) view.findViewById(R.id.rvCore);
        RecyclerViewAdapterCoreTeam recyclerViewAdapter=new RecyclerViewAdapterCoreTeam(getContext(),memberCore);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

}
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
 * Use the {@link AuxillaryTeamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AuxillaryTeamFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View view;
    private RecyclerView myRecyclerView;
    private List<TeamFragModelClass> memberAuxy;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AuxillaryTeamFragment() {
        // Required empty public constructor
    }


    public static AuxillaryTeamFragment newInstance(String param1, String param2) {
        AuxillaryTeamFragment fragment = new AuxillaryTeamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        memberAuxy= new ArrayList<>();
        memberAuxy.add(new TeamFragModelClass("Harshit Gaur","Head - Publicity/ Corporate and Media Affairs",R.drawable.harshitgaur));
        memberAuxy.add(new TeamFragModelClass("Tanya Mahajan","Head - Human Recources", R.drawable.tanyamahajan));
        memberAuxy.add(new TeamFragModelClass("Naman Aggarwal","Head - Public Relations, Head - Sponsorship",R.drawable.namanaggarwal));
        memberAuxy.add(new TeamFragModelClass("Umang Seth","Head - Event Management",R.drawable.umangseth));
        memberAuxy.add(new TeamFragModelClass("Pranav Grover","Head - Event Management",R.drawable.pranavgrover));
        memberAuxy.add(new TeamFragModelClass("Amol Puri","Head - Publications and Documentation",R.drawable.amolpuri));
        memberAuxy.add(new TeamFragModelClass("Bhavya Wahie","Head - Creativity, Head - Sponsorship",R.drawable.bvpieee));
        memberAuxy.add(new TeamFragModelClass("Shreyas Gupta","Head - Creativity",R.drawable.bvpieee));
        memberAuxy.add(new TeamFragModelClass("Ankit Goel","Head - Sponsorship",R.drawable.ankitgoel));
        memberAuxy.add(new TeamFragModelClass("Anuvrat","Head - Infrastructure and Logistics",R.drawable.pranavgrover));
        memberAuxy.add(new TeamFragModelClass("Amit Kumar","Head - Infrastructure and Logistics",R.drawable.pranavgrover));
        memberAuxy.add(new TeamFragModelClass("Shivam Sharma","Student Representative",R.drawable.shivamsharma));
        memberAuxy.add(new TeamFragModelClass("Amisha Malik","Student Representative",R.drawable.amishamalik));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_auxillary_team ,container,false);
        myRecyclerView =(RecyclerView) view.findViewById(R.id.rvAuxy);
        RecyclerViewAdapterCoreTeam recyclerViewAdapter=new RecyclerViewAdapterCoreTeam(getContext(),memberAuxy);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
            return view;
    }
}
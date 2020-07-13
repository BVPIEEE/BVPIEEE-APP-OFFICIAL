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
 * Use the {@link ChapterTeamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChapterTeamFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;
    private RecyclerView myRecyclerView;
    private List<ChapterTeamFragModel> ChapterName;

    public ChapterTeamFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ChapterTeamFragment newInstance(String param1, String param2) {
        ChapterTeamFragment fragment = new ChapterTeamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ChapterName= new ArrayList<>();
        ChapterName.add(new ChapterTeamFragModel("BVPIEEE Robotics and Automation Society (RAS)",R.drawable.raspp));
        ChapterName.add(new ChapterTeamFragModel("BVPIEEE Computer Society (CS)",R.drawable.cspp));
        ChapterName.add(new ChapterTeamFragModel("BVPIEEE Industry and Application Society (IAS)",R.drawable.iaspp));
        ChapterName.add(new ChapterTeamFragModel("BVPIEEE Women In Engineering (WIE)",R.drawable.wiepp));
        ChapterName.add(new ChapterTeamFragModel("BVPIEEE HKN Lambda ETA Chapter",R.drawable.hknpp));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_chapter2 ,container,false);
        myRecyclerView =(RecyclerView) view.findViewById(R.id.rvChaptername);
        RecyclerViewAdapterChapters recyclerViewAdapter=new RecyclerViewAdapterChapters(getContext(),ChapterName);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return view;

    }
}
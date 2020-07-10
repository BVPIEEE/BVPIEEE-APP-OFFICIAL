package com.bvpieee.ui.teams;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

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
    private List<CoreTeamModel> memberCore;

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
        memberCore.add(new CoreTeamModel("Kshitij Sidana","Chairperson, BVPIEEE",R.drawable.kshitijsidana));
        memberCore.add(new CoreTeamModel("Himani Negi","Vice Chairperson, BVPIEEE", R.drawable.himaninegi));
        memberCore.add(new CoreTeamModel("Chetanya Vaid","General Secretary, BVPIEEE",R.drawable.bvpieee));
        memberCore.add(new CoreTeamModel("Sanjana Deswal","Chief Coordinator, BVPIEEE and IAS Chairperson",R.drawable.sanjanadeswal));
        memberCore.add(new CoreTeamModel("Aaktiti Jain","Joint Secretary, BVPIEEE and WIE Vice Chairperon",R.drawable.aakritijain));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_core_tem ,container,false);
        myRecyclerView =(RecyclerView) view.findViewById(R.id.rvCore);
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(getContext(),memberCore);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

}
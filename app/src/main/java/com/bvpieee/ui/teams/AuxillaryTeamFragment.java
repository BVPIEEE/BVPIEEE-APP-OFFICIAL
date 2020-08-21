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

        memberAuxy.add(new TeamFragModelClass("Sajal Jain","Head- App Development",R.drawable.sajaljain,
                "I am a highly motivated individual with a passion for constantly developing skills and growing professionally. " +
                "I thrive for creativity, innovation and aesthetics. Domain of work: Android Mobile Application Development, UI/UX Designing",
                "https://www.linkedin.com/in/sajal-jain-1a4163177"));


        memberAuxy.add(new TeamFragModelClass("Harshit Gaur","Head - Publicity/ Corporate and Media Affairs",R.drawable.harshitgaur,
                "Beleives in innovation at its core. Dreamer and aspiring engineer." +
                "Field of work : Deep Learning, App development and AR/VR","https://www.linkedin.com/in/harshitgaur2"));

        memberAuxy.add(new TeamFragModelClass("Tanya Mahajan","Head - Human Recources", R.drawable.tanyamahajan,
                "I like to do coding,and is fine of series and listening music.","https://www.linkedin.com/in/tanya-mahajan-a19a81182"));

        memberAuxy.add(new TeamFragModelClass("Naman Aggarwal","Head - Public Relations, Head - Sponsorship",R.drawable.namanaggarwal,
                "An avid Tech geek and startup enthusiast. " +
                "Securing sponsorships and maintaining good public relations is my domain fo work","https://www.linkedin.com/in/naman-aggarwal-83b285188/"));

        memberAuxy.add(new TeamFragModelClass("Umang Seth","Head - Event Management",R.drawable.umangseth,
                "I am Robotics enthusiast. Also interested in Aerospace." +
                "Field of work : Robotics and AI","https://www.linkedin.com/in/umang-seth-9457911a7"));

        memberAuxy.add(new TeamFragModelClass("Pranav Grover","Head - Event Management",R.drawable.pranavgrover,
                "I can do work as well as get work done by people. I believe in maintaining good relations with each and everyone." +
                "I am good at managing events.","https://www.linkedin.com/in/pranav-grover-4349061a8"));

        memberAuxy.add(new TeamFragModelClass("Amol Puri","Head - Publications and Documentation",R.drawable.amolpuri,
                "Wants to learn new things, expand network and gain experience." +
                "I work as publications and documentation head and currently am working on C++.","https://www.linkedin.com/profile/view"));

        memberAuxy.add(new TeamFragModelClass("Bhavya Wahie","Head - Creativity, Head - Sponsorship",R.drawable.bvpieee,
                "Marketing Enthusiast. Video editing is my domain of work.","https://www.linkedin.com/"));
        memberAuxy.add(new TeamFragModelClass("Shreyas Gupta","Head - Creativity",R.drawable.bvpieee,"","https://www.linkedin.com/"));

        memberAuxy.add(new TeamFragModelClass("Ankit Goel","Head - Sponsorship",R.drawable.ankitgoel,
                "Hard-working and open for learning new things Getting sponsors for events is my domain of work.",
                "https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin"));

        memberAuxy.add(new TeamFragModelClass("Anuvrat","Head - Infrastructure and Logistics",R.drawable.bvpieee,
                "My responsiblity is to make arrangement for various events taking place in the society","https://www.linkedin.com"));

        memberAuxy.add(new TeamFragModelClass("Amit Kumar","Head - Infrastructure and Logistics",R.drawable.amitkumar,
                "I like to keep a positive attitude I enjoy facing challenges." +
                "Field of work : Power system, power electronics and embedded systems.","https://www.linkedin.com/in/amit-kumar-4758a41a7"));

        memberAuxy.add(new TeamFragModelClass("Shivam Sharma","Student Representative",R.drawable.shivamsharma,
                "Those who can imagine anything, can create the impossible."
        + "Trying to find the answer -Can Machines Think?","https://www.linkedin.com/in/shivamjain9990339112"));

        memberAuxy.add(new TeamFragModelClass("Amisha Malik","Student Representative",R.drawable.amishamalik,
                "I'm enthusiastic about coding and learning new technologies!"
        + "My work involves making sure that student members are fully aware of the major IEEE projects and events and are actively involved in them, leading growth.",
                "https://www.linkedin.com/in/amisha-malik-7b7852166"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_auxillary_team ,container,false);
        myRecyclerView =(RecyclerView) view.findViewById(R.id.rvAuxy);
        RecyclerViewAdapterAuxillaryTeam recyclerViewAdapter=new RecyclerViewAdapterAuxillaryTeam(getContext(),memberAuxy);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        myRecyclerView.setItemViewCacheSize(20);
        myRecyclerView.setDrawingCacheEnabled(true);
        myRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
            return view;
    }
}
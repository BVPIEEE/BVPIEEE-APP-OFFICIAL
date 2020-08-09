package com.bvpieee;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bvpieee.ui.events.EventDetailFragment;
import com.bvpieee.ui.events.EventsFragment;
import com.bvpieee.ui.home.Home2Fragment;
import com.bvpieee.ui.home.HomeFragment;
import com.bvpieee.ui.teams.TeamsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Fragment homefrag = new HomeFragment();
    Fragment eventfrag = new EventsFragment();
//    Fragment teamsfrag = new TeamsFragment();
    FloatingActionButton fab;
    Fragment home2 = new Home2Fragment();
    Fragment eventDetail = new EventDetailFragment();
    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


//        ActionBar mActionBar = getSupportActionBar();
//        mActionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);

        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        fab = findViewById(R.id.fab_home);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragments(homefrag);
            }
        });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_events, R.id.navigation_teams)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);


        fab.setRippleColor(Color.parseColor("#AFEEEE"));

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            Log.d("Bundle", "onCreate: "+bundle.getString("TEAM"));
            if (Objects.equals(bundle.getString("FRAG"), "event")) {
                Log.d("Bundle", "onCreate: if clause runs ");
                Bundle team = new Bundle();
                team.putString("TEAMS",bundle.getString("TEAM"));
                EventsFragment event = new EventsFragment();
                event.setArguments(team);
                loadFragments(event);

                Log.d("Bundle", "onCreate: if clause runs 2 ");
            }
            if(Objects.equals(bundle.getString("FRAG"), "teams")){
                Bundle team = new Bundle();
                team.putString("TEAMS",bundle.getString("CHAP"));
                TeamsFragment event = new TeamsFragment();
                event.setArguments(team);
                loadFragments(event);
            }

        }
        else
            loadFragments(homefrag);


        // Home Activity context for SharedElementTransition in EventAdapter
        com.bvpieee.adapters.EventsAdapterKt.setHomeActivityContextHolder(this);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.navigation_events:
                if (navView.getSelectedItemId() != R.id.navigation_events)
                    fragment = eventfrag;
                else
                    navView.setEnabled(false);
                break;
            case R.id.navigation_teams:
                if (navView.getSelectedItemId() != R.id.navigation_teams)
                    fragment = new TeamsFragment();
                else
                    navView.setEnabled(false);
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Intent i=new Intent(HomeActivity.this,
//                                LotteSplashActivity.class);
//                        //Intent is used to switch from one activity to another.
//                        startActivity(i);
//                        //invoke the SecondActivity.
//                        finish();
//                        //the current activity will get finished.
//                    }
//                }, SPLASH_SCREEN_TIME_OUT);
//                Intent intent=new Intent(HomeActivity.this,LotteSplashActivity.class);
//                startActivity(intent);
//                fragment = teamsfrag;
                break;
        }
        assert fragment != null;
        return loadFragments(fragment);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) instanceof HomeFragment) {
            finish();
        }

        if(getSupportFragmentManager().getBackStackEntryCount() > 0) {
            loadFragments(homefrag);
        }

        else
            super.onBackPressed();
    }

    private boolean loadFragments(Fragment fragment)
    {
//        Log.d("Bundle", "loadFragments: frag is null"+fragment.getId());

        if (fragment!=null)
        {
            Log.d("navigation", "loadFragments: Frag is loaded");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,fragment)
                    .addToBackStack(null)
                    .commit();

            return true;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

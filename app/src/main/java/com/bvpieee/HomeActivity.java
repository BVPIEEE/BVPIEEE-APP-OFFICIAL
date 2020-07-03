package com.bvpieee;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import com.bvpieee.ui.events.EventsFragment;
import com.bvpieee.ui.home.Home2Fragment;
import com.bvpieee.ui.home.HomeFragment;
import com.bvpieee.ui.teams.TeamsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Fragment homefrag = new HomeFragment();
    Fragment eventfrag = new EventsFragment();
//    Fragment teamsfrag = new TeamsFragment();
    FloatingActionButton fab;
    Fragment home2 = new Home2Fragment();
    BottomNavigationView navView;
    private static int SPLASH_SCREEN_TIME_OUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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


        loadFragments(homefrag);
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
        return loadFragments(fragment);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) instanceof HomeFragment) {
            finish();
        }

        if(getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }

        else
            super.onBackPressed();
    }

    private boolean loadFragments(Fragment fragment)
    {
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

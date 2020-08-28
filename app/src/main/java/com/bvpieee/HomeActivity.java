package com.bvpieee;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bvpieee.ui.events.EventsFragment;
import com.bvpieee.ui.home.HomeFragment;
import com.bvpieee.ui.teams.TeamsFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    Fragment homefrag = new HomeFragment();
    Fragment eventfrag = new EventsFragment();
    Fragment teamsfrag = new TeamsFragment();
    FloatingActionButton fab;
    ChipNavigationBar navView;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mgoogleSigninClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // google sign in client for logout
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mgoogleSigninClient=GoogleSignIn.getClient(this,gso);

        navView = findViewById(R.id.bottom_nav);
//        navView.setOnNavigationItemSelectedListener(this);
//        fab = findViewById(R.id.fab_home);
//        fab.setOnClickListener(v -> loadFragments(homefrag));


//        fab.setRippleColor(Color.parseColor("#AFEEEE"));

        navView.setItemSelected(R.id.navigation_home,true);

        navView.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                switch (id){
                    case R.id.navigation_home:
                        loadFragments(homefrag);
                        break;

                    case R.id.navigation_teams:
                        loadFragments(teamsfrag);
                        break;

                    case R.id.navigation_events:
                        loadFragments(eventfrag);
                        break;
                }
            }
        });


        loadFragments(homefrag);
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

    }

// menu for google logout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu,menu);
        return true;
    }
// logout menu item click
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.logout:
                // google logout code
                mgoogleSigninClient.signOut().addOnCompleteListener(this, task -> {
                    startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                    finish();
                });
                return true;
            case R.id.developers:
//                Toast.makeText(this,"Developer details will be added soon",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(this, DeveloperDetails.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        Fragment fragment = null;
//
//        switch (menuItem.getItemId()){
//            case R.id.navigation_events:
//                if (navView.getSelectedItemId() != R.id.navigation_events)
//                    fragment = eventfrag;
//                else
//                    navView.setEnabled(false);
//                break;
//            case R.id.navigation_teams:
//                if (navView.getSelectedItemId() != R.id.navigation_teams)
//                    fragment = new TeamsFragment();
//                else
//                    navView.setEnabled(false);
//                break;
//        }
//        assert fragment != null;
//        return loadFragments(fragment);
//    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.frag_container) instanceof HomeFragment) {
                finish();
        }

        if(getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }

        else {
            super.onBackPressed();
        }
    }

    private boolean loadFragments(Fragment fragment)
    {
        if (fragment!=null)
        {
            Log.d("navigation", "loadFragments: Frag is loaded");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frag_container,fragment)
                    .addToBackStack(fragment.getClass().getName())
                    .commit();

            return true;
        }
        return false;
    }

    @Override
    protected void onResume() {

        super.onResume();
    }
}

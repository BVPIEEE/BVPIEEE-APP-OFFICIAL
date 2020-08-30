package com.bvpieee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.Fragment;

import com.bvpieee.models.EventInfo;
import com.bvpieee.ui.events.EventsFragment;
import com.bvpieee.ui.home.HomeFragment;
import com.bvpieee.ui.teams.TeamsFragment;
import com.bvpieee.utils.Utils;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    Fragment homefrag = new HomeFragment();
    Fragment eventfrag = new EventsFragment();
    Fragment teamsfrag = new TeamsFragment();
    MaterialCardView materialCardView;
    ChipNavigationBar navView;
    private GoogleSignInClient mgoogleSigninClient;
    FirebaseDatabase firebaseDatabase;
    TextView upcomingEvent, date;
    DatabaseReference mDatabaseReference;
    ValueEventListener listener;
    String url;

    @Override
    protected void onDestroy() {
        if (listener != null)
            mDatabaseReference.removeEventListener(listener);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // google sign in client for logout
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mgoogleSigninClient = GoogleSignIn.getClient(this, gso);

        navView = findViewById(R.id.bottom_nav);
        upcomingEvent = findViewById(R.id.upcomingEventName);
        materialCardView = findViewById(R.id.upcoming_event_button);
        date = findViewById(R.id.date);

        firebaseDatabase = Utils.getDatabase();
        mDatabaseReference = firebaseDatabase.getReference("Events");
        mDatabaseReference.keepSynced(true);
        mDatabaseReference.orderByChild("date").addListenerForSingleValueEvent(listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    for (DataSnapshot postDataSnapshot : snapshot.getChildren()) {
                        EventInfo event = postDataSnapshot.getValue(EventInfo.class);
                        upcomingEvent.setText(event.getName());
                        date.setText(date(event.getDate()));
                        url = event.getUrl();
                        break;
                    }
                } catch (Exception e) {
                    upcomingEvent.setText("No Upcoming Event");
                    Log.d("HomeFragment", "onDataChange: " + e.getMessage());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        materialCardView.setOnClickListener(view -> {
            if (url != null) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(getColor(R.color.BottomNavBg));
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(this, Uri.parse(url));
            }
        });

        loadFragments(homefrag);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Log.d("Bundle", "onCreate: " + bundle.getString("TEAM"));
            if (Objects.equals(bundle.getString("FRAG"), "event")) {
                Log.d("Bundle", "onCreate: if clause runs ");
                Bundle team = new Bundle();
                team.putString("TEAMS", bundle.getString("TEAM"));
                EventsFragment event = new EventsFragment();
                event.setArguments(team);
                loadFragments(event);

                Log.d("Bundle", "onCreate: if clause runs 2 ");
            }
            if (Objects.equals(bundle.getString("FRAG"), "teams")) {
                Bundle team = new Bundle();
                team.putString("TEAMS", bundle.getString("CHAP"));
                TeamsFragment event = new TeamsFragment();
                event.setArguments(team);
                loadFragments(event);
            }

        }
        navView.setOnItemSelectedListener(id -> {
            switch (id) {
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
        });

    }

    public String date(String date) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat("EEE, dd MMM yy", Locale.getDefault());
        Date datetext;
        String str = null;

        try {
            datetext = inputFormat.parse(date);
            assert datetext != null;
            str = outputFormat.format(datetext);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    // menu for google logout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    // logout menu item click
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                // google logout code
                mgoogleSigninClient.signOut().addOnCompleteListener(this, task -> {
                    startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                    finish();
                });
                return true;
            case R.id.developers:
//                Toast.makeText(this,"Developer details will be added soon",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, DeveloperDetails.class);
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

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            navView.setItemSelected(R.id.navigation_home, true);
        } else {
            super.onBackPressed();
        }
    }

    private void loadFragments(Fragment fragment) {
        if (fragment != null) {
            Log.d("navigation", "loadFragments: Frag is loaded");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frag_container, fragment)
                    .addToBackStack(fragment.getClass().getName())
                    .commit();

        }
    }

}

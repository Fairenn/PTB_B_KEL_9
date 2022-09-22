package com.pusattugasakhir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
//komen ini
    BottomNavigationView bottomNavigation;
    private Object login;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeHeaderFragment() ).commit();
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;


                switch (item.getItemId()){

                    case R.id.nav_home:
                        selectedFragment = new HomeHeaderFragment();
                        getSupportActionBar().setTitle("Beranda");
                        break;
                    case R.id.nav_logbook:
                        selectedFragment = new LogbookFragment();
                        getSupportActionBar().setTitle("Logbook");
                        break;
                    case R.id.nav_profile:
                        selectedFragment = new ProfileFragment();
                        getSupportActionBar().setTitle("Profile");
                        break;
                    case R.id.nav_semhas:
                        selectedFragment = new SemhasFragment();
                        getSupportActionBar().setTitle("Seminar Hasil");
                        break;
                    case R.id.nav_sidangta:
                        selectedFragment = new SidangTAFragment();
                        getSupportActionBar().setTitle("Sidang TA");
                        break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });

    }
}
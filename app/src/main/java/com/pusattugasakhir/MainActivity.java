package com.pusattugasakhir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.pusattugasakhir.adapter.logbookAdapter;
import com.pusattugasakhir.api.APIClient;
import com.pusattugasakhir.api.APIInterface;
import com.pusattugasakhir.pojo.MultipleResource;
import com.pusattugasakhir.pojo.User;
import com.pusattugasakhir.pojo.UserList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//komen ini
    BottomNavigationView bottomNavigation;
    private Object login;
    TextView responseText;
    APIInterface apiInterface;

//    private RecyclerView rvLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        rvLogbook = findViewById(R.id.rvLogbook);
//
//        logbookAdapter adapter = new logbookAdapter(new ArrayList<>());
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//
//        rvLogbook.setLayoutManager(layoutManager);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeHeaderFragment() ).commit();
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;


                switch (item.getItemId()){

                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
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
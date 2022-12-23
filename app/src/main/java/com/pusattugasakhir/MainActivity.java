package com.pusattugasakhir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.pusattugasakhir.api.APIClient;
import com.pusattugasakhir.api.APIInterface;
import com.pusattugasakhir.pojo.MultipleResource;
import com.pusattugasakhir.pojo.User;
import com.pusattugasakhir.pojo.UserList;

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

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);
        //responseText = (TextView) findViewById(R.id.responseText);
        //apiInterface = APIClient.getClient().create(APIInterface.class);

//        /**
//         GET List Resources
//         **/
//        Call<MultipleResource> call = apiInterface.doGetListResources();
//        call.enqueue(new Callback<MultipleResource>() {
//            @Override
//            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {
//
//
//                Log.d("TAG",response.code()+"");
//
//                String displayResponse = "";
//
//                MultipleResource resource = response.body();
//                Integer text = resource.page;
//                Integer total = resource.total;
//                Integer totalPages = resource.totalPages;
//                List<MultipleResource.Datum> datumList = resource.data;
//
//                displayResponse += text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n";
//
//                for (MultipleResource.Datum datum : datumList) {
//                    displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
//                }
//
//                responseText.setText(displayResponse);
//
//            }
//
//            @Override
//            public void onFailure(Call<MultipleResource> call, Throwable t) {
//                call.cancel();
//            }
//        });
//
//        /**
//         Create new user
//         **/
//        User user = new User("morpheus", "leader");
//        Call<User> call1 = apiInterface.createUser(user);
//        call1.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user1 = response.body();
//
//                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                call.cancel();
//            }
//        });
//
//        /**
//         GET List Users
//         **/
//        Call<UserList> call2 = apiInterface.doGetUserList("2");
//        call2.enqueue(new Callback<UserList>() {
//            @Override
//            public void onResponse(Call<UserList> call, Response<UserList> response) {
//
//                UserList userList = response.body();
//                Integer text = userList.page;
//                Integer total = userList.total;
//                Integer totalPages = userList.totalPages;
//                List<UserList.Datum> datumList = userList.data;
//                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
//
//                for (UserList.Datum datum : datumList) {
//                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<UserList> call, Throwable t) {
//                call.cancel();
//            }
//        });
//
//
//        /**
//         POST name and job Url encoded.
//         **/
//        Call<UserList> call3 = apiInterface.doCreateUserWithField("morpheus","leader");
//        call3.enqueue(new Callback<UserList>() {
//            @Override
//            public void onResponse(Call<UserList> call, Response<UserList> response) {
//                UserList userList = response.body();
//                Integer text = userList.page;
//                Integer total = userList.total;
//                Integer totalPages = userList.totalPages;
//                List<UserList.Datum> datumList = userList.data;
//                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
//
//                for (UserList.Datum datum : datumList) {
//                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<UserList> call, Throwable t) {
//                call.cancel();
//            }
//        });

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
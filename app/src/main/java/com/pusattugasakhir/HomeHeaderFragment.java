package com.pusattugasakhir;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pusattugasakhir.api.APIClient;
import com.pusattugasakhir.api.APIInterface;
import com.pusattugasakhir.pojo.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeHeaderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeHeaderFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeHeaderFragment() {

        // Required empty public constructor
    }   APIInterface apiInterface;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeHeaderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeHeaderFragment newInstance(String param1, String param2) {
        HomeHeaderFragment fragment = new HomeHeaderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        Call<UserList> call2 = apiInterface.doGetUserList("2");
//        call2.enqueue(new Callback<UserList>() {
//            @Override
//            public void onResponse(Call<UserList> call, Response<UserList> response) {
//                UserList userList = response.body();
//                Integer text = userList.page;
//                Integer total = userList.total;
//                Integer totalPages = userList.totalPages;
//                List<UserList.Datum> datumList = userList.data;
//                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
//            }

//            @Override
//            public void onFailure(Call<UserList> call, Throwable t) {
//
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_header, container, false);

    }

}
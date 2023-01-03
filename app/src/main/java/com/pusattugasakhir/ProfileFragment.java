package com.pusattugasakhir;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.pusattugasakhir.api.APIClient;
import com.pusattugasakhir.pojo.LogoutResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String usn,gettoken,token;
    Button btnLogout,btngantipass,btneditprofil;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = LayoutInflater.from(getContext()).inflate(R.layout.fragment_profile, container, false);
        btnLogout =rootview.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        btngantipass =rootview.findViewById(R.id.btnGantiPassword);
        btngantipass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gantipass();
            }
        });
        btneditprofil =rootview.findViewById(R.id.btneditprofil);
        btneditprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editprofil();
            }
        });
        return rootview;

    }


    public void logout(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("userkey", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "bearer " + gettoken;

        retrofit2.Call<LogoutResponse> logoutResponseCall = APIClient.getUserInterface().userLogout(token);
        logoutResponseCall.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {

                if (response.code() == 200){
                    if (response.isSuccessful()){
                        Intent intent = new Intent(getActivity(), login.class);
                        startActivity(intent);
                        Toast.makeText(getActivity(),response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        sharedPreferences.edit().clear().apply();
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
    public void gantipass(){
        Intent intent = new Intent(getActivity(), gantiPasswordActivity.class);
        startActivity(intent);
    }
    public void editprofil(){
        Intent intent = new Intent(getActivity(), ubah_profil.class);
        startActivity(intent);
    }
}
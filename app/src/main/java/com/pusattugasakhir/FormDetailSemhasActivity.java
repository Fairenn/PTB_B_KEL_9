package com.pusattugasakhir;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.pusattugasakhir.api.APIClient;
import com.pusattugasakhir.pojo.DetailSeminarHasilResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormDetailSemhasActivity extends AppCompatActivity {
    String token, gettoken;
    TextView tvNamaDetail,tvNimDetail,tvTglAjuDetail,tvTglSeminarDetail,tvPembiDetail1,tvPembiDetail2;
//    ReviewersItem pembimbing;
//    int thesis_id;
//    String register,seminar;

//    public void getDetailSemhasActivity(int thesis_id,String register, String seminar){
//        DetailSeminarHasilRequest detailSeminarHasilRequest = new DetailSeminarHasilRequest();
//        Call<DetailSeminarHasilResponse> detailSeminarHasilResponseCall = APIClient.getUserInterface().getDetailSeminarHasil(token,thesis_id);
//        detailSeminarHasilResponseCall.enqueue(new Callback<DetailSeminarHasilResponse>() {
//            @Override
//            public void onResponse(Call<DetailSeminarHasilResponse> call, Response<DetailSeminarHasilResponse> response) {
//                if (response.isSuccessful()){
//                    DetailSeminarHasilResponse detailSeminarHasilResponse = response
//                }
//            }
//
//            @Override
//            public void onFailure(Call<DetailSeminarHasilResponse> call, Throwable t) {
//
//            }
//        }Callback < DetailSeminarHasilResponse >);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_detail_semhas);
        tvNamaDetail = findViewById(R.id.tvNamaDetail);
        tvNimDetail = findViewById(R.id.tvNimDetail);
        tvTglAjuDetail = findViewById(R.id.tvTglAjuDetail);
        tvTglSeminarDetail = findViewById(R.id.tvTglSeminarDetail);
        tvPembiDetail1 = findViewById(R.id.tvPembiDetail1);
        tvPembiDetail2 = findViewById(R.id.tvPembiDetail2);
        int[] list_pembimbing={
                R.id.tvPembiDetail1,
                R.id.tvPembiDetail2
        };
        SharedPreferences sharedPreferences = getSharedPreferences("userkey", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;

        Integer thesis_id = sharedPreferences.getInt("thesis_id",0);
        String nama = sharedPreferences.getString("name","");
        String nim = sharedPreferences.getString("username","");



        retrofit2.Call<DetailSeminarHasilResponse> detailSeminarHasilResponseCall = APIClient.getUserInterface().getDetailSeminarHasil(token,thesis_id);
        detailSeminarHasilResponseCall.enqueue(new Callback<DetailSeminarHasilResponse>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<DetailSeminarHasilResponse> call, Response<DetailSeminarHasilResponse> response) {
                Toast.makeText(FormDetailSemhasActivity.this, "BerHasil Mendapatkan Data", Toast.LENGTH_SHORT).show();
                Log.d("FormDetailSemhasActivity-Debug", response.toString());

            }

            @Override
            public void onFailure(Call<DetailSeminarHasilResponse> call, Throwable t) {

            }
        });



    }


}
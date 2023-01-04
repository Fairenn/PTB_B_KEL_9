package com.pusattugasakhir;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pusattugasakhir.adapters.PesertaAdapter;
import com.pusattugasakhir.api.APIClient;
import com.pusattugasakhir.api.Config;
import com.pusattugasakhir.pojo.AudiencesItem;
import com.pusattugasakhir.pojo.ListPesertaSemhasResponse;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSemhasActivity extends AppCompatActivity{

    private RecyclerView rvPeserta;
    String token, gettoken;
    int id =312;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_semhas);

        SharedPreferences sharedPreferences = getSharedPreferences("com.pusattugasakhir.SHARED_KEY", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer" + gettoken;
//        id =


//        Config config = new Config();

//        if (){
            Button btnajukan = findViewById(R.id.btnAjukanSemhas);
            btnajukan.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick (View view){

                    Intent intent_ajukan = new Intent(DetailSemhasActivity.this, FormPengajuanSemhas.class);
                    startActivity(intent_ajukan);
                }

            });
//        }

//        else if() {
            rvPeserta = findViewById(R.id.rv_peserta_semhas);

            PesertaAdapter adapter = new PesertaAdapter();

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);

            rvPeserta.setLayoutManager(layoutManager);
            rvPeserta.setAdapter(adapter);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//           retrfit2.Call<ListPesertaSemhasResponse> call = config.configRetrofit().getListPesertaSemhas(token,id);
            retrofit2.Call<ListPesertaSemhasResponse> listPesertaSemhasResponseCall = APIClient.getUserInterface().getListPesertaSemhas(token,id);
            listPesertaSemhasResponseCall.enqueue(new Callback<ListPesertaSemhasResponse>() {
            @Override
            public void onResponse(Call<ListPesertaSemhasResponse> call, Response<ListPesertaSemhasResponse> response) {
                Toast.makeText(DetailSemhasActivity.this, "BerHasil Mendapatkan Data", Toast.LENGTH_SHORT).show();
                Log.d("ListPesertaSemHas-Debug", response.toString());
                ListPesertaSemhasResponse getListPesertaSemhasResponse = response.body();
                if (getListPesertaSemhasResponse != null) {
                    List<AudiencesItem> listAudiences = getListPesertaSemhasResponse.getAudiences();
                    Log.d("ListPesertaSemHas-Debug", String.valueOf(listAudiences.size()));
                    adapter.setItemAudiences(listAudiences);
                }
            }

            @Override
            public void onFailure(Call<ListPesertaSemhasResponse> call, Throwable t) {
                Toast.makeText(DetailSemhasActivity.this, "Gagal Mendapatkan Data", Toast.LENGTH_SHORT).show();
            }
            });
            Button btntambah = findViewById(R.id.btnTambahPeserta);
            btntambah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent_tambah = new Intent(DetailSemhasActivity.this, TambahPesertaActivity.class);
                    startActivity(intent_tambah);
                }
            });
//        }
    }


//    @Override
//    public void onItemPesertaClick(AudiencesItem peserta) {
//        Intent detailIntent = new Intent(this, PesertaDetailActivity.class);
//        detailIntent.putExtra("Peserta Yang Menghadiri Seminar Hasil", peserta.getName());
//        startActivity(detailIntent);
//    }
}

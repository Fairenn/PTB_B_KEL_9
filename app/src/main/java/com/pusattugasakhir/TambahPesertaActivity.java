package com.pusattugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pusattugasakhir.api.Config;

public class TambahPesertaActivity extends AppCompatActivity {
    String token, gettoken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_peserta);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPreferences = getSharedPreferences("com.pusattugasakhir.SHARED_KEY", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token","");
        token = "Bearer" +gettoken;

        Config config = new Config();

        //input post code disini
        
        //btn input peserta dan balik ke list peserta semhas
        Button btntmbhpeserta = findViewById(R.id.btnTambahPesertaSemHas);
        btntmbhpeserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_tmbh = new Intent(TambahPesertaActivity.this, ListPesertaSemhasActivity.class);
                startActivity(intent_tmbh);
            }
        });

    }
}
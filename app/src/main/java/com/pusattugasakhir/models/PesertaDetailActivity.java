package com.pusattugasakhir.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.pusattugasakhir.R;

public class PesertaDetailActivity extends AppCompatActivity {

    String namaPeserta;
    TextView textDetailNamaPeserta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peserta_detail);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            namaPeserta = detailIntent.getStringExtra("NAMA_PESERTA");
            textDetailNamaPeserta = findViewById(R.id.textDetailNamaPeserta);
            textDetailNamaPeserta.setText(namaPeserta);
        }

    }
}
package com.pusattugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class form_pengajuan_semhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_pengajuan_semhas);
    }
    public void ajukansemhas (View view) {
        Intent intent = new Intent(form_pengajuan_semhas.this, input_peserta_semhas.class);
        startActivity(intent);
    }
}
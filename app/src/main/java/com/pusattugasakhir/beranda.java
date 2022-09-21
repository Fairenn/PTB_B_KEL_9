package com.pusattugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class beranda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beranda);
        ImageView profil = findViewById(R.id.profil);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Perintah Intent Explicit pindah halaman ke activity_detail
                Intent intent = new Intent(beranda.this, ubah_profil.class);
                startActivity(intent);
            }
        });
    }
}
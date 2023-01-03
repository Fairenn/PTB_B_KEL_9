package com.pusattugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuSemhasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_semhas);
        Button btnlistpes = findViewById(R.id.btnlistpeserta);
        Button btndetsemhas = findViewById(R.id.btndetsemhasil);
        btnlistpes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intentpeserta = new Intent(MenuSemhasActivity.this,ListPesertaSemhasActivity.class);
//                startActivity(intentpeserta);
                startActivity(new Intent(MenuSemhasActivity.this, DetailSemhasActivity.class));
            }
        });

        btndetsemhas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intentdetailsemhas = new Intent(MenuSemhasActivity.this,FormDetailSemhasActivity.class);
//                startActivity(intentdetailsemhas);
                startActivity(new Intent(MenuSemhasActivity.this, FormDetailSemhasActivity.class));
            }
        });
    }
}

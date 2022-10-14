package com.pusattugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class form_pengajuan_sidang_ta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pengajuan_sidang_ta);

        Button button = findViewById(R.id.btnajukansidangta);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(form_pengajuan_sidang_ta.this, FormDetailSidangTAActivity.class);
                startActivity(intent);
            }
        });
    }
}
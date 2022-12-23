package com.pusattugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class input_peserta_semhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_peserta_semhas);
        Button button = findViewById(R.id.btndetailsemhas);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_semhas = new Intent(input_peserta_semhas.this, FormDetailSemhasActivity.class);
                startActivity(intent_semhas);
            }
        });
    }
}
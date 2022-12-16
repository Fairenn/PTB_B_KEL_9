package com.pusattugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class form_detail_semhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_detail_semhas);
        Button button = findViewById(R.id.btnokdetailsemhas);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_semhas = new Intent(form_detail_semhas.this, MainActivity.class);
                startActivity(intent_semhas);
            }
        });
    }
}
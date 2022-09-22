package com.pusattugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        Button btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perintah Intent Explicit pindah halaman ke activity_detail
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
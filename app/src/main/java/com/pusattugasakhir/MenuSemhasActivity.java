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
        Button button1 = findViewById(R.id.btnlistpeserta);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MenuSemhasActivity.this,ListPesertaSemhasActivity.class);
                startActivity(intent1);
            }
        });
        Button button2 = findViewById(R.id.btndetsemhasil);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MenuSemhasActivity.this,FormDetailSemhasActivity.class);
                startActivity(intent2);
            }
        });
    }
}

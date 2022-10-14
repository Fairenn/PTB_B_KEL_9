package com.pusattugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class tampilanAwal<Protected> extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIMEOUT = 2000;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.tampilanawal_activity);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent (tampilanAwal.this,login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN_TIMEOUT);
    }
}

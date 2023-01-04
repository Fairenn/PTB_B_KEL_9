package com.pusattugasakhir;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.pusattugasakhir.api.Config;

public class FormPengajuanSemhas extends AppCompatActivity {

    Button btnajukansemhas;
    String token, gettoken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_pengajuan_semhas);
        btnajukansemhas = findViewById(R.id.btnajukansemhasil);
        btnajukansemhas.setOnClickListener(view -> {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            SharedPreferences sharedPreferences = getSharedPreferences("com.pusattugasakhir.SHARED_KEY", Context.MODE_PRIVATE);
            gettoken = sharedPreferences.getString("token","");
            token = "Bearer" +gettoken;

            Config config = new Config();
            //input post code disini



            Intent intent_ajusemhas = new Intent(FormPengajuanSemhas.this, ListPesertaSemhasActivity.class);
            startActivity(intent_ajusemhas);

            intent_ajusemhas.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent_ajusemhas, PendingIntent.FLAG_ONE_SHOT);

            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder1 = new NotificationCompat.Builder(getApplicationContext(), "CH1")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentText("Semhas telah Di ajukan")
                    .setContentTitle("Semhas")
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);
            NotificationManager notificationManager1 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("CH1", "Notifikasi", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager1.createNotificationChannel(channel);
            }
            notificationManager1.notify(0, notificationBuilder1.build());


        });
        Intent ajuSemhasIntent = getIntent();
        if(ajuSemhasIntent != null){

        }
    }
}
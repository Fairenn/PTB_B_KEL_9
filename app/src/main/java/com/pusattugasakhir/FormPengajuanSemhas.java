package com.pusattugasakhir;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class FormPengajuanSemhas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_pengajuan_semhas);
        Button button = findViewById(R.id.btnajukansemhasil);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_semhas = new Intent(FormPengajuanSemhas.this, MenuSemhasActivity.class);
                startActivity(intent_semhas);
                intent_semhas.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent_semhas, PendingIntent.FLAG_ONE_SHOT);

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


            }
        });
    }
}
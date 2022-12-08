package com.pusattugasakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

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

public class form_pengajuan_sidang_ta extends AppCompatActivity {
    private Button btnajukansidangta;

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
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0, intent, PendingIntent.FLAG_ONE_SHOT);

                Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(),"CH1")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                                .setContentText("Sidang TA telah Di ajukan")
                                        .setContentTitle("Sidang TA")
                                                .setAutoCancel(true)
                                                        . setSound(defaultSoundUri)
                                                                .setContentIntent(pendingIntent);
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel channel = new NotificationChannel("CH1","Notifikasi",NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager.createNotificationChannel(channel);
                }
                notificationManager.notify(0,notificationBuilder.build());


            }
        });
    }
}
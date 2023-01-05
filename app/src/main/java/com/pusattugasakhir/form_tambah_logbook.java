package com.pusattugasakhir;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class form_tambah_logbook extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_tambah_logbook);

        Button button = findViewById(R.id.btntambahlogbook);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_tambah= new Intent(form_tambah_logbook.this, input_peserta_semhas.class);
                startActivity(intent_tambah);
                intent_tambah.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                Toast.makeText(form_tambah_logbook.this, "logbook ditambahkan", Toast.LENGTH_SHORT).show();
             }
         });
    }
}

//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        View button = view.findViewById(R.id.btntambahlogbook);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), form_tambah_logbook.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
////        return inflater.inflate(R.layout.form_tambah_logbook, container, false);
//    }
//}

package com.pusattugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pusattugasakhir.api.Config;
import com.pusattugasakhir.pojo.CreatePesertaSemhasResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahPesertaActivity extends AppCompatActivity {
    String token, gettoken, nim;
    EditText editIdNim;
    private Button buttonShow, tambahPeserta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_peserta);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        //input post code disini

        //btn input peserta dan balik ke list peserta semhas

        buttonShow = findViewById(R.id.btnTambahPesertaSemHas);
        buttonShow.setOnClickListener(view -> {
            Intent intent_tmbh = new Intent(TambahPesertaActivity.this, ListPesertaSemhasActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(TambahPesertaActivity.this);
            stackBuilder.addNextIntentWithParentStack(intent_tmbh);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(0,
                            PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
            editIdNim = findViewById(R.id.editIdNim);
            SharedPreferences sharedPreferences = getSharedPreferences("userkey", Context.MODE_PRIVATE);
            gettoken = sharedPreferences.getString("token","");
            token = "Bearer" +gettoken;

            Intent detailIntent = getIntent();
            Integer id = detailIntent.getIntExtra("id", 0);

            tambahPeserta = findViewById(R.id.btnTambahPesertaSemHas);
            tambahPeserta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nim = editIdNim.getText().toString();

                    int nim2 = Integer.parseInt(nim);

                    Config config = new Config();
                    Call<CreatePesertaSemhasResponse> call = config.configRetrofit().tambahPeserta(token,id,nim2);
                    call.enqueue(new Callback<CreatePesertaSemhasResponse>() {
                        @Override
                        public void onResponse(Call<CreatePesertaSemhasResponse> call, Response<CreatePesertaSemhasResponse> response) {
                            CreatePesertaSemhasResponse createPesertaSemhasResponse = response.body();
                            String message;
                            JSONObject jsonObject = null;
                            Log.d("status", createPesertaSemhasResponse.getMessage());
                            if (response.code()==200){
                                if(response.isSuccessful()){
                                    message = response.body().getMessage();
                                    Toast.makeText(TambahPesertaActivity.this, message, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(TambahPesertaActivity.this, ListPesertaSemhasActivity.class);
                                    setResult(RESULT_OK, intent);
                                    startActivity(intent);
                                }
                            }else if(response.code() == 403){
                                if(!response.isSuccessful()){
                                    try{
                                        jsonObject = new JSONObject(response.errorBody().string());
                                        message = jsonObject.getString("message");
                                    }catch (JSONException | IOException e){
                                        e.printStackTrace();
                                    }
                                }

                            }else{
                                message = createPesertaSemhasResponse.getMessage();
                                Toast.makeText(TambahPesertaActivity.this, message, Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<CreatePesertaSemhasResponse> call, Throwable t) {
                            Toast.makeText(TambahPesertaActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });



            startActivity(intent_tmbh);
        });


//        Button btntmbhpeserta = findViewById(R.id.btnTambahPesertaSemHas);
//        btntmbhpeserta.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });

    }
}
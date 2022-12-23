package com.pusattugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.pusattugasakhir.api.APIClient;
import com.pusattugasakhir.api.APIInterface;
import com.pusattugasakhir.pojo.LoginResponse;
import com.pusattugasakhir.pojo.MultipleResource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {


    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        Button btnlogin = findViewById(R.id.btnlogin1);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        btnlogin.setOnClickListener(v -> {

            TextInputLayout username = (TextInputLayout) findViewById(R.id.textInputNIM);
            String strname = username.getEditText().getText().toString();

            TextInputLayout password = (TextInputLayout) findViewById(R.id.textInputPassword);
            String strpass = password.getEditText().getText().toString();

            Toast.makeText(this, strname +" "+ strpass, Toast.LENGTH_SHORT).show();

            Call<LoginResponse> call = apiInterface.loginUser(strname, strpass);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    Log.d("TAG", response.code()+"");
                    String displayResponse="";

                    LoginResponse loginResponse = response.body();
                    String token = loginResponse.getAuthorisation().getToken();


//                         Perintah Intent Explicit pindah halaman ke activity_detail
                     Intent intent = new Intent(login.this, MainActivity.class);
                     startActivity(intent);

                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Log.d("TAG", t.getMessage());

                }
            });


        });
    }
}
package com.pusattugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.pusattugasakhir.api.APIClient;
import com.pusattugasakhir.api.APIInterface;
import com.pusattugasakhir.pojo.LoginRequest;
import com.pusattugasakhir.pojo.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {
    TextInputLayout til_edit_usn, til_edit_pw;
    Button btn_login;
    String usn, pw;

    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btnlogin1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                til_edit_usn = findViewById(R.id.textInputNIMLogin);
                til_edit_pw = findViewById(R.id.textInputPasswordLogin);
                usn = til_edit_usn.getEditText().getText().toString();
                pw = til_edit_pw.getEditText().getText().toString();

                if (TextUtils.isEmpty(usn) || TextUtils.isEmpty(pw)) {
                    Toast.makeText(login.this, "username / password harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    login(usn, pw);
                }
            }
        });
    }

    public void onClick_Button_Login(View view) {

    }

    public void login(String username, String password) {
        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername(usn);
//        loginRequest.setPassword(pw);
//
//        String username = til_edit_usn.getEditText().toString();
//        String password = til_edit_pw.getEditText().toString();

        Toast.makeText(this, username + "+ " + password, Toast.LENGTH_SHORT).show();

        Call<LoginResponse> loginResponseCall = APIClient.getUserInterface().userLogin(username, password);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse.getAuthorisation().getToken() != null) {
                        String token = loginResponse.getAuthorisation().getToken();
                        String name = loginResponse.getUser().getName();
                        String username = loginResponse.getUser().getUsername();
                        String eml = loginResponse.getUser().getEmail();
                        Log.i("success", token);
                        SharedPreferences sharedPreferences = getSharedPreferences("userkey", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("token", token);
                        editor.putString("name", name);
                        editor.putString("email", eml);
                        editor.putString("username", username);
                        Log.d("email", eml);
                        editor.apply();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Bundle extras = new Bundle();
                                Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(login.this, MainActivity.class).putExtras(extras));
                            }
                        }, 700);
                    }
                } else {
                    Toast.makeText(login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(login.this, "Throwable" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


//        Button btnlogin = findViewById(R.id.btnlogin1);
//
//        apiInterface = APIClient.getClient().create(APIInterface.class);
//
//        btnlogin.setOnClickListener(v -> {
//
//            TextInputLayout username = (TextInputLayout) findViewById(R.id.textInputNIM);
//            String strname = username.getEditText().getText().toString();
//
//            TextInputLayout password = (TextInputLayout) findViewById(R.id.textInputPassword);
//            String strpass = password.getEditText().getText().toString();
//
//            Toast.makeText(this, strname +" "+ strpass, Toast.LENGTH_SHORT).show();
//
//            Call<LoginResponse> call = apiInterface.userLogin(strname, strpass);
//            call.enqueue(new Callback<LoginResponse>() {
//                @Override
//                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                    Log.d("TAG", response.code()+"");
//                    String displayResponse="";
//
//                    LoginResponse loginResponse = response.body();
//                    String token = loginResponse.getAuthorisation().getToken();
//
//
////                         Perintah Intent Explicit pindah halaman ke activity_detail
//                     Intent intent = new Intent(login.this, MainActivity.class);
//                     startActivity(intent);
//
//                }
//
//                @Override
//                public void onFailure(Call<LoginResponse> call, Throwable t) {
//                    Log.d("TAG", t.getMessage());
//
//                }
//            });
//
//
//        });


}
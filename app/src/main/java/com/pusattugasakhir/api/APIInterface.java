package com.pusattugasakhir.api;

import com.pusattugasakhir.pojo.ListPesertaSemhasResponse;
import com.pusattugasakhir.pojo.LoginRequest;
import com.pusattugasakhir.pojo.LoginResponse;
import com.pusattugasakhir.pojo.LogoutResponse;
import com.pusattugasakhir.pojo.MultipleResource;
import com.pusattugasakhir.pojo.User;
import com.pusattugasakhir.pojo.UserList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    @POST("api/logout")
    Call<LogoutResponse> userLogout(
            @Header("Authorization") String token
    );
    @GET("api/thesis/seminars/322/audiences")
    Call<ListPesertaSemhasResponse> getListPesertaSemhas(
            @Header("Authorization") String token
    );

//    @POST("api/me")
//    Call<>



//    @GET("/api/unknown")
//    Call<MultipleResource> doGetListResources();
//
//    @POST("/api/users")
//    Call<User> createUser(@Body User user);
//
//    @POST("/api/logout")
//    Call<LogoutResponse> userLogout(
//            @Header()
//    )
//
//    @GET("/api/me")
//    Call<UserList> doGetUserList(@Query("page") String page);

//    @FormUrlEncoded
//    @POST("/api/login")
//    Call<LoginResponse> loginUser(@Field("username") String username, @Field("password") String password);

//    @FormUrlEncoded
//    @POST("/api/logout")
//    Call<LogoutResponse> logoutUser(@Field("username") String username, @Field("password") String password);



}
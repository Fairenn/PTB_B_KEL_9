package com.pusattugasakhir.api;

import com.pusattugasakhir.pojo.LoginResponse;
import com.pusattugasakhir.pojo.MultipleResource;
import com.pusattugasakhir.pojo.User;
import com.pusattugasakhir.pojo.UserList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();

    @POST("/api/users")
    Call<User> createUser(@Body User user);

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/login")
    Call<LoginResponse> loginUser(@Field("username") String username, @Field("password") String password);

}

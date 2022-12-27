package com.pusattugasakhir.pojo;

import com.google.gson.annotations.SerializedName;

public class Authorisation{

    @SerializedName("type")
    private String type;

    @SerializedName("token")
    private String token;

    public String getType(){
        return type;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setType(String type) {
        this.type = type;
    }
}
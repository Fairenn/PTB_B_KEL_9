package com.pusattugasakhir.pojo;

import com.google.gson.annotations.SerializedName;

public class User{
//test
    @SerializedName("password")
    private String password;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;


    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;

    @SerializedName("role")
    private Object role;

    @SerializedName("active")
    private int active;

    @SerializedName("created_at")
    private Object createdAt;

    @SerializedName("email_verified_at")
    private Object emailVerifiedAt;

    @SerializedName("current_team_id")
    private Object currentTeamId;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("type")
    private int type;

    @SerializedName("token")
    private Object token;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("two_factor_recovery_codes")
    private Object twoFactorRecoveryCodes;



    @SerializedName("profile_photo_path")
    private Object profilePhotoPath;

    @SerializedName("two_factor_secret")
    private Object twoFactorSecret;


    public Object getRole(){
        return role;
    }

    public int getActive(){
        return active;
    }

    public Object getCreatedAt(){
        return createdAt;
    }

    public Object getEmailVerifiedAt(){
        return emailVerifiedAt;
    }

    public Object getCurrentTeamId(){
        return currentTeamId;
    }

    public String getAvatar(){
        return avatar;
    }

    public int getType(){
        return type;
    }

    public Object getToken(){
        return token;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public Object getTwoFactorRecoveryCodes(){
        return twoFactorRecoveryCodes;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword(){return password;}

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getProfilePhotoPath(){
        return profilePhotoPath;
    }

    public Object getTwoFactorSecret(){
        return twoFactorSecret;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername(){
        return username;
    }
}
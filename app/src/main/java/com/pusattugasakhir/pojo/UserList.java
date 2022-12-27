package com.pusattugasakhir.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    @SerializedName("page")
    public Integer page;
    @SerializedName("per_page")
    public Integer perPage;
    @SerializedName("total")
    public Integer total;
    @SerializedName("total_pages")
    public Integer totalPages;
    @SerializedName("data")
    public List<Datum> data = new ArrayList();

    public class Datum {

        @SerializedName("id")
        public Integer id;
        @SerializedName("username")
        public String username;
        @SerializedName("name")
        public String name;
        @SerializedName("avatar")
        public String avatar;

    }
}

package com.week6.retrofitv1;


import com.google.gson.annotations.SerializedName;

public class PostResponse {

    private int userId;
    private int id;
    private String title;

    @SerializedName("body")
    private String post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return title;
    }

    public void setBody(String body) {
        this.title = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

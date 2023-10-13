package com.mohanad.myapplication.Model;

public class User {
    private String userId;
    private String email;
    private String password;
    private String imageUrl;
    public User(String userId , String email , String password , String imageUrl){
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

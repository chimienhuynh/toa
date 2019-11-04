package com.bluesky.toa.models;

import com.bluesky.toa.data.DataUtil;

import java.util.List;

public class Account {

    private String id;
    private String email;
    private String userName;
    private String password;
    private String createdAt;
    private Profile profile;
    private List<Post> posts;
    private List<Comment> comments;

    public Account(String email, String userName, String password) {
        this.id = DataUtil.getUniqueID();
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.createdAt = DataUtil.getCurrentTimeString();
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

package com.bluesky.toa.models;

import com.bluesky.toa.data.DataUtil;

import java.util.List;

public class Post {

    private String id;
    private Account account;
    private String createdAt;
    private String updatedAt;
    private String title;
    private String content;
    private List<Comment> comments;

    public Post(Account account) {
        this.id = DataUtil.getUniqueID();
        this.createdAt = DataUtil.getCurrentTimeString();
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

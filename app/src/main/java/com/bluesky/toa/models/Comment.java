package com.bluesky.toa.models;

import com.bluesky.toa.data.DataUtil;

public class Comment {

    private String id;
    private Account account;
    private Post post;
    private String createdAt;
    private String updatedAt;
    private String content;

    public Comment(Account account, Post post) {
        this.id = DataUtil.getUniqueID();
        this.createdAt = DataUtil.getCurrentTimeString();
        this.account = account;
        this.post = post;
    }

    public String getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Post getPost() {
        return post;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

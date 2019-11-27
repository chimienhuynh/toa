package com.bluesky.toa.ui.chat.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class User{

    @Id
    public long id;
    private String name;
    private String location;
    private String gender;
    private String bio;
    private String company_name;
    private int service;
    private int project_type;
    private String description;
    private byte[] image;

    public User(String name, String location, String gender, String bio, String company_name, int service, int project_type, String description, byte[] image) {
        this.name = name;
        this.location = location;
        this.gender = gender;
        this.bio = bio;
        this.company_name = company_name;
        this.service = service;
        this.project_type = project_type;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getProject_type() {
        return project_type;
    }

    public void setProject_type(int project_type) {
        this.project_type = project_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

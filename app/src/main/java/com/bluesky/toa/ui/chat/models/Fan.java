package com.bluesky.toa.ui.chat.models;

public class Fan {

    private String name;
    private String location;
    private String gender;
    private byte[] image;

    public Fan(String name, String location, String gender, byte[] image) {
        this.name = name;
        this.location = location;
        this.gender = gender;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

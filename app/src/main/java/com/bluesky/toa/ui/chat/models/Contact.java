package com.bluesky.toa.ui.chat.models;

import android.graphics.Bitmap;

public class Contact {
    Bitmap photo;
    String name;

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

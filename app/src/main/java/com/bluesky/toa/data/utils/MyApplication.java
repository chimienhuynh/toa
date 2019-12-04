package com.bluesky.toa.data.utils;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("My Application", "Called----------->>>>>>>");
       // ObjectBox.init(this);
    }
}
package com.bluesky.toa.data.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DataUtil {

    public static String getCurrentTimeString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy--MM-dd HH:mm:ss");
        Date currentTime = new Date(System.currentTimeMillis());
        return formatter.format(currentTime);
    }

    public static String getUniqueID() {
        return UUID.randomUUID().toString();
    }
}

package com.bb.moviedatabase.Util;

import android.util.Log;

public class ErrorLogger {
    private static final String TAG = "TAG_N";
    private static final String ERROR_PREFIX = "Error:";

    public static void logError(Exception exception) {
        Log.d(TAG, ERROR_PREFIX + exception.getLocalizedMessage());
    }
    public static void logDebug(String log){
        Log.d(TAG, log);
    }
}

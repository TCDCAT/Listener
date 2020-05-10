package com.example.listener.util;

import android.util.Log;

public class LogUtil {
    private static int ERROR = 5;
    private static int WARN = 4;
    private static int INFO = 3;
    private static int DEBUG = 2;
    private static int VERBOSE = 1;
    private static int LEVEL = 6;

    public static void E(String tag, String msg) {
        if (ERROR >= LEVEL) {
            Log.e(tag, msg);
        }
    }
    public static void W(String tag, String msg) {
        if (WARN >= LEVEL) {
            Log.e(tag, msg);
        }
    }
    public static void I(String tag, String msg) {
        if (INFO >= LEVEL) {
            Log.e(tag, msg);
        }
    }
    public static void D(String tag, String msg) {
        if (DEBUG >= LEVEL) {
            Log.e(tag, msg);
        }
    }
    public static void V(String tag, String msg) {
        if (VERBOSE >= LEVEL) {
            Log.e(tag, msg);
        }
    }
}

package com.example.listener;

import android.app.Application;
import android.content.Context;


public class MyApplication extends Application {
    private static Context mContext;

    public static Context getInstance() {
        if (mContext == null) {
            return new MyApplication();
        }
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

}

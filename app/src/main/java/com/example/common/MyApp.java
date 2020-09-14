package com.example.common;

import android.app.Application;
import android.content.Context;


public class MyApp extends Application {
    private static Context context;
    public static Context getContext(){
        return context;
    }
    public void onCreate() {
        super.onCreate();
        context=this;
        initUtil();
    }
    private void initUtil() {
//        FIR.init(this);
    }
}

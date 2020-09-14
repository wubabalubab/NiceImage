package com.example.common;

import android.app.Activity;

import java.util.ArrayList;

public class ActivityController {
    private static final ArrayList<Activity> ACTIVITIES=new ArrayList<>();
    public static void addActivity(Activity activity){
        ACTIVITIES.add(activity);
    }
    public static void removeActivity(Activity activity){
        ACTIVITIES.remove(activity);
    }
    public static void finishAll(){
        synchronized (ACTIVITIES){
            for (Activity activity : ACTIVITIES) {
                if (activity != null&&!activity.isFinishing()) {
                    activity.finish();
                }
            }
        }
    }
    public static void exitApp(){
        finishAll();
        System.exit(0);
    }
}

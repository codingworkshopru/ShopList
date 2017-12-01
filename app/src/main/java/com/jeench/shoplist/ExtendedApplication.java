package com.jeench.shoplist;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Radik on 01.12.2017.
 */

public class ExtendedApplication extends Application {
    @Override public void onCreate() {
        super.onCreate();
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }
    }
}

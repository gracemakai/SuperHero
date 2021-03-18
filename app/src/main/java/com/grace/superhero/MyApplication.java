package com.grace.superhero;

import android.app.Application;

import com.jaredrummler.cyanea.Cyanea;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Cyanea.init(this, getResources());
    }
}

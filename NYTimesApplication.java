package com.example.nytimesarticleapp;

import android.app.Activity;
import android.app.Application;

import com.example.nytimesarticleapp.depndencyinjection.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class NYTimesApplication extends Application implements HasActivityInjector {

    private static NYTimesApplication sInstance;


    public static NYTimesApplication getAppContext() {
        return sInstance;
    }



    private static synchronized void setInstance(NYTimesApplication app) {
        sInstance = app;
    }
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
        setInstance(this);
    }

    private void initializeComponent() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingInjector;
    }
}

package com.example.myfirstapp;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class AppClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}

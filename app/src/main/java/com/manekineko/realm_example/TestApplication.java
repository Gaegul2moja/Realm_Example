package com.manekineko.realm_example;

import android.app.Application;

import io.realm.Realm;

public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}

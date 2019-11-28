package com.sample.gradle.demo;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

/**
 * Project Name：GradleDemo
 * Created by hejunqiu on 2019/11/27 15:50
 * Description:
 */
public class App extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        ProductFlavors flavors = new ProductFlavors();
        flavors.initProduct();
    }
}
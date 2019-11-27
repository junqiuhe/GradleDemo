package com.sample.gradle.demo;

import android.app.Application;

/**
 * Project Name：GradleDemo
 * Created by hejunqiu on 2019/11/27 15:50
 * Description:
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ProductFlavors flavors = new ProductFlavors();
        flavors.initProduct();
    }
}
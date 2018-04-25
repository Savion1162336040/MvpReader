package com.example.mvpreaderjava;

import android.app.Application;

import com.example.mvpreaderjava.di.component.AppComponent;
import com.example.mvpreaderjava.di.component.DaggerAppComponent;
import com.example.mvpreaderjava.di.module.AppModule;
import com.example.mvpreaderjava.di.module.HttpModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by sw116 on 2018/4/19.
 */

public class MyApplication extends Application {
    public static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //清除Logger适配器，添加AndroidLogAdapter格式适配器
        Logger.clearLogAdapters();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public AppComponent component;

    public AppComponent createComponent() {
        if (component == null) {
            component = DaggerAppComponent.builder()
                    .httpModule(new HttpModule())
                    .appModule(new AppModule(this))
                    .build();
        }
        return component;
    }

}

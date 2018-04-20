package com.example.mvpreaderjava.di.module;

import com.example.mvpreaderjava.MyApplication;
import com.example.mvpreaderjava.modle.helper.HttpHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sw116 on 2018/4/19.
 */
@Module
public class AppModule {

    private MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public MyApplication provideApp() {
        return application;
    }

}

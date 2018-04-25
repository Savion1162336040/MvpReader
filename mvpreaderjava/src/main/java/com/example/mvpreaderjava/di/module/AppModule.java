package com.example.mvpreaderjava.di.module;

import com.example.mvpreaderjava.MyApplication;
import com.example.mvpreaderjava.modle.DataManager;
import com.example.mvpreaderjava.modle.helper.HttpHelper;
import com.example.mvpreaderjava.modle.helper.HttpManager;
import com.google.gson.Gson;

import java.security.PublicKey;

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

    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    public HttpHelper provideHttpHelper(HttpManager manager) {
        return manager;
    }

    @Provides
    @Singleton
    public DataManager provideDataManager(HttpHelper manager) {
        return new DataManager(manager);
    }
}

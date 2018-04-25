package com.example.mvpreaderjava.di.component;

import com.example.mvpreaderjava.MyApplication;
import com.example.mvpreaderjava.di.module.AppModule;
import com.example.mvpreaderjava.di.module.HttpModule;
import com.example.mvpreaderjava.modle.DataManager;
import com.example.mvpreaderjava.modle.helper.HttpManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sw116 on 2018/4/19.
 */
@Component(modules = {HttpModule.class, AppModule.class})
@Singleton
public interface AppComponent {

    MyApplication getApp();

    DataManager getDataManager(); //数据中心

    HttpManager getHttpManager();//api接口

}

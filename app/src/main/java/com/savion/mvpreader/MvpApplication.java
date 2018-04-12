package com.savion.mvpreader;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.savion.mvpreader.di.component.AppComponent;
import com.savion.mvpreader.di.module.AppModule;
import com.savion.mvpreader.di.module.HttpModule;

/**
 * Created by Administrator on 2018-01-02.
 */

public class MvpApplication extends MultiDexApplication {

    public static MvpApplication instance;

    public static AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static AppComponent createAppComponent(){
        if (appComponent==null){
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(MvpApplication.instance)).httpModule(new HttpModule()).build();
        }
        return appComponent;
    }

}

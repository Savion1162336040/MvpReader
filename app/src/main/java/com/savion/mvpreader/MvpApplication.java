package com.savion.mvpreader;

import android.app.Application;

import com.savion.mvpreader.di.component.ApplicationComponent;
import com.savion.mvpreader.di.component.DaggerApplicationComponent;
import com.savion.mvpreader.di.module.ApplicationModule;
import com.savion.mvpreader.di.module.RetrofitModule;

/**
 * Created by savion on 2018/4/16.
 */

public class MvpApplication extends Application {

    public static MvpApplication instance;
    public static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static ApplicationComponent createComponent() {
        if (applicationComponent == null)
            applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(instance)).retrofitModule(new RetrofitModule()).build();
        return applicationComponent;
    }

}

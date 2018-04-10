package com.savion.mvpreader;

import android.app.Application;

/**
 * Created by Administrator on 2018-01-02.
 */

public class MvpApplication extends Application {

    public static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    private void createAppComponent(){


    }

}

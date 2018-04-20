package com.example.mvpreaderjava.di.module;

import android.app.Activity;

import com.example.mvpreaderjava.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sw116 on 2018/4/19.
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity() {
        return activity;
    }
}

package com.savion.mvpreader.di.module;

import android.app.Activity;

import com.savion.mvpreader.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by savion on 2018/4/9.
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

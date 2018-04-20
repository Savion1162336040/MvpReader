package com.example.mvpreaderjava.di.module;

import android.app.Activity;

import com.example.mvpreaderjava.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sw116 on 2018/4/19.
 */
@Module
public class FragmentModule {
    private Activity activity;

    public FragmentModule(Activity activity) {
        this.activity = activity;
    }

    @PerFragment
    @Provides
    public Activity provideActivity() {
        return activity;
    }
}

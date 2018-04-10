package com.savion.mvpreader.di.module;

import android.app.Activity;

import com.savion.mvpreader.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by savion on 2018/4/9.
 */

@Module
public class FragmentModule {

    private Activity activity;

    public FragmentModule(Activity activity) {
        this.activity = activity;
    }
    @Provides
    @PerFragment
    public Activity provideActivity(){
        return activity;
    }

}

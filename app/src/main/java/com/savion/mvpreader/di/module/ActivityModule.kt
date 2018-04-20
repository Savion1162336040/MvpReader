package com.savion.mvpreader.di.module

import android.app.Activity

import com.savion.mvpreader.di.scope.PerActivity

import dagger.Module
import dagger.Provides

/**
 * Created by savion on 2018/4/9.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @PerActivity
    fun provideActivity(): Activity {
        return activity
    }


}

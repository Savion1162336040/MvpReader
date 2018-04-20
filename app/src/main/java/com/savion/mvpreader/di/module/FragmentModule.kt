package com.savion.mvpreader.di.module

import android.app.Activity

import com.savion.mvpreader.di.scope.PerFragment

import dagger.Module
import dagger.Provides

/**
 * Created by savion on 2018/4/9.
 */

@Module
class FragmentModule(private val activity: Activity) {
    @Provides
    @PerFragment
    fun provideActivity(): Activity {
        return activity
    }

}

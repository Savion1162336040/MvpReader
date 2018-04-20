package com.savion.mvpreader.di.component

import android.app.Activity

import com.savion.mvpreader.di.scope.PerActivity
import com.savion.mvpreader.ui.activity.MainActivity
import com.savion.mvpreader.di.module.ActivityModule

import dagger.Component

/**
 * Created by savion on 2018/4/9.
 */
@Component(modules = arrayOf(ActivityModule::class), dependencies = arrayOf(ApplicationComponent::class))
@PerActivity
interface ActivityComponent {

    val activity: Activity

    fun inject(activity: MainActivity)

}

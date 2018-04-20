package com.savion.mvpreader.di.component

import android.app.Activity

import com.savion.mvpreader.di.module.FragmentModule
import com.savion.mvpreader.di.scope.PerFragment
import com.savion.mvpreader.ui.fragment.NewsContentFragment
import com.savion.mvpreader.ui.fragment.NewsFragment

import dagger.Component

/**
 * Created by savion on 2018/4/9.
 */

@Component(modules = arrayOf(FragmentModule::class), dependencies = arrayOf(ApplicationComponent::class))
@PerFragment
interface FragmentComponet {

    val activity: Activity

    fun inject(fragment: NewsFragment)

    fun inject(fragment: NewsContentFragment)

}

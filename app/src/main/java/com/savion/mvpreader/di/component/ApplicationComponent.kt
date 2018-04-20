package com.savion.mvpreader.di.component

import com.savion.mvpreader.MvpApplication
import com.savion.mvpreader.di.module.ApplicationModule
import com.savion.mvpreader.di.module.RetrofitModule
import com.savion.mvpreader.model.http.HttpManager

import javax.inject.Singleton

import dagger.Component

/**
 * Created by savion on 2018/4/16.
 */
@Component(modules = arrayOf(RetrofitModule::class, ApplicationModule::class))
@Singleton
interface ApplicationComponent {

    val application: MvpApplication

    val httpManager: HttpManager


}

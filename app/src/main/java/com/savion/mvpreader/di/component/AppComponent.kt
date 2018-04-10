package com.savion.mvpreader.di.component

import android.app.Application
import com.savion.mvpreader.di.module.AppModule
import com.savion.mvpreader.di.module.HttpModule
import com.savion.mvpreader.model.http.service.HttpManager
import dagger.Component
import javax.inject.Singleton

/**
 * Created by savion on 2018/4/10.
 */
@Component(modules = arrayOf(AppModule::class, HttpModule::class))
@Singleton
interface AppComponent {

    fun getApp(): Application

    fun getHttpManager(): HttpManager

}
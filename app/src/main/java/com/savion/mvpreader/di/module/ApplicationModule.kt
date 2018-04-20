package com.savion.mvpreader.di.module

import com.savion.mvpreader.MvpApplication
import com.savion.mvpreader.model.behavior.HttpHelper
import com.savion.mvpreader.model.http.HttpManager

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Created by savion on 2018/4/16.
 */

@Module
class ApplicationModule(private val application: MvpApplication) {

    @Provides
    @Singleton
    fun provideApplication(): MvpApplication {
        return this.application
    }

    @Provides
    @Singleton
    fun provideHttpHelper(httpManager: HttpManager): HttpHelper {
        return httpManager
    }

}


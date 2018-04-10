package com.savion.mvpreader.di.module

import com.savion.mvpreader.MvpApplication
import com.savion.mvpreader.model.DataManager
import com.savion.mvpreader.model.behavior.HttpHelper
import com.savion.mvpreader.model.http.HttpManager
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by savion on 2018/4/10.
 */
@Module
class AppModule @Inject constructor(val application: MvpApplication) {

    @Provides
    @Singleton
    fun provideApp(): MvpApplication {
        return application
    }

    @Provides
    @Singleton
    fun provideHttpManager(helper: HttpManager): HttpHelper {
        return helper
    }
    @Provides
    @Singleton
    fun provideDataManager(dataManager: DataManager): DataManager {
        return dataManager
    }

}
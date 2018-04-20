package com.savion.mvpreader.di.module

import com.savion.mvpreader.Constant
import com.savion.mvpreader.common.SystemUtil
import com.savion.mvpreader.di.qualifier.JuheUrl
import com.savion.mvpreader.model.http.service.JUHEService

import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by savion on 2018/4/16.
 */
@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
    }

    @Provides
    @Singleton
    fun provideHttpBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }

    @Provides
    @Singleton
    fun provideHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        val cacheFile = File(Constant.CACHE_PATH)
        val cache = Cache(cacheFile, java.lang.Long.valueOf((1024 * 1024 * 50).toLong())!!)
        val cacheInterceptor = Interceptor { chain ->
            var request = chain.request()
            if (!SystemUtil.isNetworkConnected()) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build()
            }
            val response = chain.proceed(request)
            if (SystemUtil.isNetworkConnected()) {
                val maxAge = 0
                // 有网络时, 不缓存, 最大保存时长为0
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .removeHeader("Pragma")
                        .build()
            } else {
                // 无网络时，设置超时为4周
                val maxStale = 60 * 60 * 24 * 28
                response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build()
            }
            response
        }
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor)
        builder.addInterceptor(cacheInterceptor)
        builder.cache(cache)
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS)
        builder.readTimeout(20, TimeUnit.SECONDS)
        builder.writeTimeout(20, TimeUnit.SECONDS)
        //错误重连
        builder.retryOnConnectionFailure(true)
        return builder.build()
    }

    @Provides
    @Singleton
    @JuheUrl
    fun provideJUHEApi(retrofitBuilder: Retrofit.Builder, httpClient: OkHttpClient): Retrofit {
        return provideRetrofit(retrofitBuilder, httpClient, JUHEService.API_BASE_URL)
    }

    @Provides
    @Singleton
    fun provideJUHERetrofit(@JuheUrl retrofit: Retrofit): JUHEService {
        return retrofit.create(JUHEService::class.java)
    }

    fun provideRetrofit(retrofitBuilder: Retrofit.Builder, httpClient: OkHttpClient, url: String): Retrofit {
        return retrofitBuilder
                .baseUrl(url)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}

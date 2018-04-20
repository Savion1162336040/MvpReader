package com.example.mvpreaderjava.di.module;

import com.example.mvpreaderjava.Constant;
import com.example.mvpreaderjava.SystemUtil;
import com.example.mvpreaderjava.di.qualifier.JuheUrl;
import com.example.mvpreaderjava.modle.helper.JUHEService;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sw116 on 2018/4/19.
 */
@Module
public class HttpModule {
    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    public OkHttpClient providerOkHttpClient(OkHttpClient.Builder builder) {
        File cacheFile = new File(Constant.CACHE_PATH);
        Cache cache = new Cache(cacheFile, Long.valueOf((1024 * 1024 * 50)));
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtil.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (SystemUtil.isNetworkConnected()) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

    /**
     * 提供聚合数据接口service
     * @param retrofit
     * @return
     */
    @Provides
    @Singleton
    public JUHEService provideJUHEService(@JuheUrl Retrofit retrofit) {
        return retrofit.create(JUHEService.class);
    }

    @Provides
    @Singleton
    @JuheUrl
    public Retrofit provideJUHERetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return provideRetrofit(builder, client, JUHEService.API_BASE_URL);
    }

    public Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder.baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                client(client).build();
    }

}

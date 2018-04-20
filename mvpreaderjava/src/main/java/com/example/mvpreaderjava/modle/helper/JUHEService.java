package com.example.mvpreaderjava.modle.helper;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sw116 on 2018/4/19.
 */

public interface JUHEService {
    public static final String API_BASE_URL = "http://v.juhe.cn/";
    public static final String KEY = "192bc976d907659b9a337857eafc1b2f";

    /**
     * 获取头条新闻
     */
    @GET("toutiao/index")
    Flowable<JUHENewsResponse<JUHENewsResponse.Result<JUHENewsResponse.Data>>> getJuheNews(@Query(value = "type") String type, @Query(value = "key") String key);


}

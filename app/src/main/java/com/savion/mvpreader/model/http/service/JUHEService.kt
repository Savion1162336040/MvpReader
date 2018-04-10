package com.savion.mvpreader.model.http.service

import com.savion.mvpreader.model.response.JUHENewsResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by savion on 2018/4/10.
 */
interface JUHEService {

    companion object {
        val KEY: String
            get() = "192bc976d907659b9a337857eafc1b2f"
        val API_BASE_URL: String
            get() = "http://v.juhe.cn/"
    }

    /**
     * 获取头条新闻
     */
    @GET("toutiao/index")
    fun getJUHENews(@Query(value = "type") type: String, @Query(value = "key") key: String): Flowable<JUHENewsResponse<JUHENewsResponse.JUHENewsResponseResule<List<JUHENewsResponse.JUHENewsResponseData>>>>

}
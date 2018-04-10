package com.savion.mvpreader.model.behavior

import com.savion.mvpreader.model.response.JUHENewsResponse
import io.reactivex.Flowable

/**
 * Created by savion on 2018/4/10.
 */
interface HttpHelper {

    // 获取聚合数据头条信息
    fun getJuheNews(type: String): Flowable<JUHENewsResponse<JUHENewsResponse.JUHENewsResponseResule<List<JUHENewsResponse.JUHENewsResponseData>>>>

}
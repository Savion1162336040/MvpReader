package com.savion.mvpreader.model.http

import com.savion.mvpreader.model.behavior.HttpHelper
import com.savion.mvpreader.model.http.service.JUHEService
import com.savion.mvpreader.model.response.JUHENewsResponse
import io.reactivex.Flowable

import javax.inject.Inject

/**
 * Created by savion on 2018/4/10.
 */

class HttpManager @Inject
constructor(private val juheService: JUHEService) : HttpHelper {

    override fun getJuheNews(type: String): Flowable<JUHENewsResponse<JUHENewsResponse.JUHENewsResponseResule<List<JUHENewsResponse.JUHENewsResponseData>>>> {
        return juheService.getJUHENews(type, JUHEService.API_BASE_URL)
    }
}

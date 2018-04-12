package com.savion.mvpreader.model

import com.savion.mvpreader.model.behavior.HttpHelper
import com.savion.mvpreader.model.http.HttpManager
import com.savion.mvpreader.model.response.JUHENewsResponse
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by savion on 2018/4/10.
 */
class DataManager @Inject constructor(val httpHelper: HttpManager) : HttpHelper {

    override fun getJuheNews(type: String): Flowable<JUHENewsResponse<JUHENewsResponse.JUHENewsResponseResule<List<JUHENewsResponse.JUHENewsResponseData>>>> {
        return httpHelper.getJuheNews(type)
    }
}
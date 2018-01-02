package com.savion.mvpreader.presenter

import android.os.Handler
import com.savion.mvpreader.OkHttpUtils
import com.savion.mvpreader.bean.News
import com.savion.mvpreader.bean.Result
import com.savion.mvpreader.view.NewsMessageView
import com.sw.mvp.presenter.BasePresenter

/**
 * Created by Administrator on 2018-01-02.
 */
class NewsMessagePresenter : BasePresenter<NewsMessageView>() {
    fun getNewsMessage(key: String) {
        if (isViewAttach()){
            view!!.refreshStart()
            OkHttpUtils.getInstance().getNewsMessage(key, this)
        }
    }

    fun cancelCall() {
        OkHttpUtils.getInstance().cancelCall(OkHttpUtils.API_NEWS_MESSAGE)
    }

    fun onSuccess(result: Result<List<News>>) {
        if (isViewAttach()) {
            view!!.refreshCompelete()
            view!!.notifyData(result.content!!)
        }
    }

    fun onFailed(exception: String) {
        if (isViewAttach()) {
            view!!.showError(exception)
            view!!.refreshCompelete()
        }
    }
}
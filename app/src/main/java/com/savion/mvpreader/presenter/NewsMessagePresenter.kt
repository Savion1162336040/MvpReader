package com.savion.mvpreader.presenter

import com.savion.mvpreader.bean.News
import com.savion.mvpreader.bean.Result
import com.savion.mvpreader.common.RxUtils
import com.savion.mvpreader.contract.NewsMessageContract
import com.savion.mvpreader.contract.RxPresenter
import com.savion.mvpreader.model.DataManager
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018-01-02.
 */
class NewsMessagePresenter @Inject constructor(val dataManager: DataManager) : RxPresenter<NewsMessageContract.View>(), NewsMessageContract.Presenter<NewsMessageContract.View> {

    override fun cancelCall() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess(result: Result<List<News>>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailed(exception: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNewsMessage(key: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        dataManager.getJuheNews(key).compose(RxUtils.commonFlowableScheduler()).subscribe()
    }
//    fun getNewsMessage(key: String) {
//        if (isViewAttach()){
//            view!!.refreshStart()
//            OkHttpUtils.getInstance().getNewsMessage(key, this)
//        }
//    }
//
//    fun cancelCall() {
//        OkHttpUtils.getInstance().cancelCall(OkHttpUtils.API_NEWS_MESSAGE)
//    }
//
//    fun onSuccess(result: Result<List<News>>) {
//        if (isViewAttach()) {
//            view!!.refreshCompelete()
//            view!!.notifyData(result.content!!)
//        }
//    }
//
//    fun onFailed(exception: String) {
//        if (isViewAttach()) {
//            view!!.showError(exception)
//            view!!.refreshCompelete()
//        }
//    }
}
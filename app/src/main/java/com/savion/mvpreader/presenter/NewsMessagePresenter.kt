package com.savion.mvpreader.presenter

import com.savion.mvpreader.model.bean.News
import com.savion.mvpreader.model.bean.Result
import com.savion.mvpreader.common.RxUtils
import com.savion.mvpreader.contract.NewsMessageContract
import com.savion.mvpreader.contract.RxPresenter
import com.savion.mvpreader.model.DataManager
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
        dataManager.getJuheNews(key).compose(RxUtils.commonFlowableScheduler()).doOnNext { t ->
            view.refreshCompelete()
            if (t.error_code == 0) {
                if (t.result!!.stat == 1) {
                    view.notifyData(t.result!!.data!!)
                } else
                    view.showError("no data")
            } else {
                view.showError(t.reason!!)
            }
        }.doOnError { t: Throwable? ->
                    view.showError(String.format("getNewsMessage error:%s", t!!.message))
                }.doOnSubscribe {
                    view.refreshStart()
                }.subscribe()
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
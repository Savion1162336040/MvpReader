package com.savion.mvpreader.presenter

import com.savion.mvpreader.R
import com.savion.mvpreader.bean.Tab
import com.savion.mvpreader.common.RxUtils
import com.savion.mvpreader.contract.NewsMainContract
import com.savion.mvpreader.contract.RxPresenter
import com.savion.mvpreader.model.parse.TabsParse
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2017-12-29.
 */
class NewsMainPresenter @Inject constructor() : RxPresenter<NewsMainContract.View>(), NewsMainContract.Presenter<NewsMainContract.View> {

    override fun getTabs() {
        Observable.create<List<Tab>> { emitter ->
            run {
                if (isViewAttach()) {
                    val tabs = view.getIContext().resources.getStringArray(R.array.news_tab)
                    if (tabs == null || tabs.size <= 0)
                        emitter.onError(IllegalStateException("no news data to show"))
                    else {
                        emitter.onNext(TabsParse(tabs).parse())
                    }
                } else
                    emitter.onComplete()
            }
        }.doOnNext { t -> view.loadTabs(t) }.doOnError { t -> view.showError(t.message!!) }.compose(RxUtils.commonObserableScheduler()).subscribe()
    }
//    fun getTabs() {
//        if (isViewAttach()) {
//            val tabs = view!!.getIContext().resources.getStringArray(R.array.news_tab)
//            if (tabs == null || tabs.size == 0) {
//                view!!.showError("no tab for show")
//            } else {
//                view!!.loadTabs(TabsParse(tabs).parse())
//            }
//        }
//    }
}
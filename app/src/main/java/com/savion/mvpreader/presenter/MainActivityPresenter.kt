package com.savion.mvpreader.presenter

import com.savion.mvpreader.R
import com.savion.mvpreader.model.bean.Tab
import com.savion.mvpreader.common.RxUtils
import com.savion.mvpreader.contract.MainActivityContract
import com.savion.mvpreader.contract.RxPresenter
import com.savion.mvpreader.model.parse.TabsParse

import javax.inject.Inject

import io.reactivex.Observable

/**
 * Created by savion on 2018/4/9.
 */

class MainActivityPresenter @Inject
constructor() : RxPresenter<MainActivityContract.View>(), MainActivityContract.Presenter<MainActivityContract.View> {
    override fun getTabs() {
        add(Observable.create<Any> { emitter ->
            if (isViewAttach()) {
                val tabs = view.getIContext().resources.getStringArray(R.array.main_tab)
                if (tabs == null || tabs.size <= 0)
                    emitter.onError(IllegalStateException("no tabs data to show"))
                else
                    emitter.onNext(TabsParse(tabs).parse())
            } else
                emitter.onComplete()
        }.doOnNext { o -> view.loadTabs(o as List<Tab>) }.doOnError { throwable -> view.showError(throwable.message!!) }.compose(RxUtils.commonObserableScheduler()).subscribe())
    }
}

package com.savion.mvpreader.presenter

import com.savion.mvpreader.R
import com.savion.mvpreader.model.TabsParse
import com.savion.mvpreader.view.MainActivityView
import com.savion.mvpreader.view.NewsFragmentView
import com.sw.mvp.presenter.BasePresenter

/**
 * Created by Administrator on 2017-12-29.
 */
class NewsPresenter : BasePresenter<NewsFragmentView>() {
    fun getTabs() {
        if (isViewAttach()) {
            val tabs = view!!.getIContext().resources.getStringArray(R.array.news_tab)
            if (tabs == null || tabs.size == 0) {
                view!!.showError("no tab for show")
            } else {
                view!!.loadTabs(TabsParse(tabs).parse())
            }
        }
    }
}
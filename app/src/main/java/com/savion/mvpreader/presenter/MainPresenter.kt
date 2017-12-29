package com.savion.mvpreader.presenter

import android.support.design.internal.NavigationMenu
import android.support.v7.view.SupportMenuInflater
import android.view.MenuInflater
import com.savion.mvpreader.R
import com.savion.mvpreader.model.TabsParse
import com.savion.mvpreader.view.MainActivityView
import com.sw.mvp.presenter.BasePresenter

/**
 * Created by Administrator on 2017-12-29.
 */
class MainPresenter : BasePresenter<MainActivityView>() {
    fun getTabs() {
        if (isViewAttach()) {
            val tabs = view!!.getIContext().resources.getStringArray(R.array.main_tab)
            if (tabs == null || tabs.size == 0) {
                view!!.showError("no tab for show")
            } else {
                view!!.loadTabs(TabsParse(tabs).parse())
            }
        }
    }
}
package com.savion.mvpreader.view

import com.savion.mvpreader.bean.Tab
import com.sw.mvp.view.IBaseView

/**
 * Created by Administrator on 2017-12-28.
 */
interface MainActivityView : IBaseView {
    fun openDrawer()
    fun transforFragment(tag: String)
    fun loadTabs(tab: ArrayList<Tab>)
}
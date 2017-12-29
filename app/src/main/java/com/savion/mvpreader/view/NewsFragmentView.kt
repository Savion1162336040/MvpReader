package com.savion.mvpreader.view

import com.savion.mvpreader.bean.Tab
import com.sw.mvp.view.IBaseView

/**
 * Created by Administrator on 2017-12-29.
 */
interface NewsFragmentView:IBaseView {

    fun addTab(tab:Tab)
    fun changeTabs(tag:String)
    fun loadTabs(tab: ArrayList<Tab>)
    fun loadTabTops(title:ArrayList<String>)
    fun addTabTop(title:String)

}
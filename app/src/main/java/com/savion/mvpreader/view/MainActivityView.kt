package com.savion.mvpreader.view

import com.savion.mvpreader.presenter.IBasePresenter

/**
 * Created by Administrator on 2017-12-28.
 */
interface MainActivityView :IBaseView<IBasePresenter> {

    fun openDrawer()
    fun transforFragment(index:Int)


}
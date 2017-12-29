package com.sw.mvp.view

import android.content.Context
import com.sw.mvp.presenter.BasePresenter

/**
 * Created by Administrator on 2017-12-22.
 * baseview identify basic view behavior
 * 定义了各个view的基本行为
 * ibaseview由BaseActivity来实现其基本行为
 */
interface IBaseView {
    fun showToast(str:String)
    fun showError(str:String)
    fun showLoading()
    fun dismissLoading()
    fun getIContext():Context

}
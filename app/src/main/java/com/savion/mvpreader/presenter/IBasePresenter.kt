package com.savion.mvpreader.presenter

/**
 * Created by Administrator on 2017-12-28.
 */
interface IBasePresenter {
    //view开始加载
    fun onStart()
    //绑定view
    fun attachView()
    //解绑view
    fun dettechView()
    //当前view是否已经绑定
    fun isViewAttach()

}
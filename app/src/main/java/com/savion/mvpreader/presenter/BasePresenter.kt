package com.sw.mvp.presenter

import com.sw.mvp.view.IBaseView

/**
 * Created by Administrator on 2017-12-22.
 * basepresenter 同步activity的生命周期，
 * 当activity销毁时dettach,
 * 创建时attach,
 * presenter内每一次更新view动作瓣都需要判断isViewAttach,
 * 这样保证只在activity还存活时更新UI
 */
open class BasePresenter<V : IBaseView> {
    var view: V? = null
        get() {
            return field
        }

    fun attachView(iview: V) {
        this.view = iview
    }

    fun dettachView() {
        view = null
    }

    fun isViewAttach(): Boolean {
        if (view == null) return false else return true
    }
}
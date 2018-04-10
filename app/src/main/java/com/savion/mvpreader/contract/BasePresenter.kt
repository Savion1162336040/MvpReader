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
open interface BasePresenter<V : IBaseView> {

    open fun attachView(iview: V)

    open fun dettachView()

    open fun isViewAttach(): Boolean
}
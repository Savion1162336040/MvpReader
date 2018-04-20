package com.example.mvpreaderjava.mvp;


/**
 * Created by sw116 on 2018/4/19.
 */
public interface BasePresenter<V extends BaseView> {
    //关联view
    void attachView(V view);

    //解除关联view
    void dettachView();

    //是否已经关联
    boolean isAttached();
}

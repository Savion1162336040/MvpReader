package com.example.mvpreaderjava.ui.base;


import com.example.mvpreaderjava.mvp.BasePresenter;

import javax.inject.Inject;

/**
 * Created by sw116 on 2018/4/19.
 * mvp相关基础activity,所有mvp的activity都需要继承此activity
 */
public abstract class BaseActivity<P extends BasePresenter> extends SimpleActivity {
    @Inject
    P mPresenter;

    @Override
    protected void onViewCreated() {
        inject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.dettachView();
    }

    //注入视图
    protected abstract void inject();

}

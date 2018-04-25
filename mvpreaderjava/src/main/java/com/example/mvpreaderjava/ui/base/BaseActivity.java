package com.example.mvpreaderjava.ui.base;


import com.example.mvpreaderjava.MyApplication;
import com.example.mvpreaderjava.di.component.ActivityComponent;
import com.example.mvpreaderjava.di.component.DaggerActivityComponent;
import com.example.mvpreaderjava.di.module.ActivityModule;
import com.example.mvpreaderjava.mvp.BasePresenter;

import javax.inject.Inject;

/**
 * Created by sw116 on 2018/4/19.
 * mvp相关基础activity,所有mvp的activity都需要继承此activity
 */
public abstract class BaseActivity<P extends BasePresenter> extends SimpleActivity {
    @Inject
    P mPresenter;

    protected ActivityComponent getComponent() {
        return DaggerActivityComponent.builder().appComponent(MyApplication.instance.createComponent()).activityModule(getModule()).build();
    }

    protected ActivityModule getModule() {
        return new ActivityModule(mActivity);
    }

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

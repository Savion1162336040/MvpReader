package com.savion.mvpreader.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.savion.mvpreader.MvpApplication;
import com.savion.mvpreader.di.component.ActivityComponent;
import com.savion.mvpreader.di.component.DaggerActivityComponent;
import com.savion.mvpreader.di.module.ActivityModule;
import com.sw.mvp.presenter.BasePresenter;

import javax.inject.Inject;

import dagger.Module;

/**
 * Created by savion on 2018/4/9.
 * mvp相关基础activity
 * 实现mvp的activity都需要继承此activity
 */
public abstract class BaseActivity<P extends BasePresenter> extends SimpleActivity {
    @Inject
    P presenter;

    //依赖注入
    protected abstract void inject();

    protected ActivityComponent getComponent() {
        return DaggerActivityComponent.builder().applicationComponent(MvpApplication.createComponent()).activityModule(getModule()).build();
    }

    protected ActivityModule getModule() {
        return new ActivityModule(activity);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.dettachView();
    }

    @Override
    protected void onViewCreated() {
        inject();
        if (presenter != null)
            presenter.attachView(this);
    }

}

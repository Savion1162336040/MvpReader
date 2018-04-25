package com.example.mvpreaderjava.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


import com.example.mvpreaderjava.MyApplication;
import com.example.mvpreaderjava.di.component.DaggerFragmentComponent;
import com.example.mvpreaderjava.di.component.FragmentComponent;
import com.example.mvpreaderjava.di.module.FragmentModule;
import com.example.mvpreaderjava.mvp.BasePresenter;

import java.io.Serializable;

import javax.inject.Inject;

/**
 * Created by sw116 on 2018/4/19.
 */

public abstract class BaseFragment<A extends Serializable, P extends BasePresenter> extends SimpleFragment<A> {
    @Inject
    protected P mPresenter;

    protected FragmentComponent getComponent() {
        //return DaggerFragmentComponent.create().component(MyApplication.instance.createComponent()).fragmentModule(getModule()).build();
        return DaggerFragmentComponent.builder().appComponent(MyApplication.instance.createComponent()).fragmentModule(getModule()).build();
    }

    protected FragmentModule getModule() {
        return new FragmentModule(_mActivity);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null)
            mPresenter.dettachView();
    }

    protected abstract void inject();

}

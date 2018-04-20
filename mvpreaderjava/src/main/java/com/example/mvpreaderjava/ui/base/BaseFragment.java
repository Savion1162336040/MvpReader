package com.example.mvpreaderjava.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


import com.example.mvpreaderjava.mvp.BasePresenter;

import javax.inject.Inject;

/**
 * Created by sw116 on 2018/4/19.
 */

public abstract class BaseFragment<P extends BasePresenter> extends SimpleFragment {
    @Inject
    protected P mPresenter;

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

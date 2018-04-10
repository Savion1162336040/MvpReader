package com.savion.mvpreader.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.savion.mvpreader.di.component.DaggerFragmentComponet;
import com.savion.mvpreader.di.component.FragmentComponet;
import com.savion.mvpreader.di.module.FragmentModule;
import com.sw.mvp.presenter.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017-12-29.
 */

public abstract class BaseFragment<P extends BasePresenter> extends SimpleFragment {
    //    private boolean isVisible = false;
//    private boolean isFirst = true;
//    private boolean isPrepare = false;
    @Inject
    protected P presenter;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null)
            presenter.dettachView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inject();
        if (presenter != null)
            presenter.attachView(this);
    }

    protected FragmentModule getModule() {
        return new FragmentModule(activity);
    }

    protected FragmentComponet getComponent() {
        return DaggerFragmentComponet.builder().fragmentModule(getModule()).build();
    }

    protected abstract void inject();

    //    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        // TODO Auto-generated method stub
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//            isVisible = true;
//            lazyLoad();
//        } else {
//            isVisible = false;
//        }
//    }
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        // TODO Auto-generated method stub
//        super.onActivityCreated(savedInstanceState);
//        isPrepare = true;
//        lazyLoad();
//    }
//
//    private void lazyLoad() {
//        if (isFirst && isPrepare && isVisible) {
//            initData(true);
//            isFirst = false;
//        }
//    }

//    abstract void initData(boolean showLoading);
}

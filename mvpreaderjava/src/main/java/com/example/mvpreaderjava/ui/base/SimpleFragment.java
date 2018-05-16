package com.example.mvpreaderjava.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.mvpreaderjava.mvp.BaseView;
import com.example.mvpreaderjava.ui.widget.DialogAlert;
import com.example.mvpreaderjava.ui.widget.EmptyLayout;
import com.example.mvpreaderjava.ui.widget.imp.OnDialogCallBack;
import com.orhanobut.logger.Logger;
import com.savion.loadinglayout.LoadingLayout;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by sw116 on 2018/4/19.
 */

public abstract class SimpleFragment<A extends Serializable> extends SupportFragment implements BaseView, OnDialogCallBack {

    Unbinder mUnbinder;

    protected A mArgument;

    protected static String ARGS_KEY = "argument";

    private boolean hasArgument = false;

    private EmptyLayout emptyLayout=null;
    private LoadingLayout emptyView=null;

    protected DialogAlert mDialogAlert;

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        try {
            A o = (A) args.getSerializable(ARGS_KEY);
            hasArgument = true;
        } catch (Exception e) {
            hasArgument = false;
        }
    }

    protected void setMArgument(A argument) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARGS_KEY, argument);
        setArguments(bundle);
    }

    protected A getMArgument() {
        A a = null;
        if (hasArgument) {
            a = (A) getArguments().getSerializable(ARGS_KEY);
        } else {
            a = null;
        }
        return a;
    }

    protected boolean hasArgument() {
        return hasArgument;
    }

    public void setUpEmptyLayout(EmptyLayout layout) {
        this.emptyLayout = layout;
    }

    public void setUpEmptyView(LoadingLayout emptyView) {
        this.emptyView = emptyView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("hasArgument", hasArgument);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            hasArgument = savedInstanceState.getBoolean("hasArgument");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(_mActivity, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loading() {
//        if (emptyLayout != null) {
//            emptyLayout.showLoading();
//        }
        if (emptyView != null) {
            emptyView.showLoading();
        }
    }

    @Override
    public void error() {
        showToast("error");
//        if (emptyLayout != null) {
//            emptyLayout.showError();
//        }
        if (emptyView != null) {
            emptyView.showError();
        }
    }

    @Override
    public void content() {
        if (emptyView != null) {
            emptyView.showContent();
        }
//        if (emptyLayout != null) {
//            emptyLayout.hide();
//        }
    }

    @Override
    public void empty() {
        if (emptyView != null) {
            emptyView.showEmpty();
        }
//        if (emptyLayout != null) {
//            emptyLayout.showEmpty();
//        }
    }

    @Override
    public void complete() {
        Logger.d("state complete");
        if (emptyLayout != null) {
            emptyLayout.hide();
        }
    }

    @Override
    public void progress(String m) {
        Bundle bundle = new Bundle();
        bundle.putString(DialogAlert.ARGS_MESSAGE, TextUtils.isEmpty(m) ? "loading..." : m);
        bundle.putInt(DialogAlert.ARGS_STATE, DialogAlert.STATE_LOADING);
        bundle.putString(DialogAlert.ARGS_FROM, DialogAlert.FROM_DIALOGFRAGMENT);
        mDialogAlert = DialogAlert.newInstance(bundle);
        mDialogAlert.setCallBack(this);
        mDialogAlert.show(getFragmentManager(), "progress");
    }

    @Override
    public void setProgressState(int state, String msg) {
        if (mDialogAlert != null && !mDialogAlert.isHidden()) {
            mDialogAlert.setState(state);
            mDialogAlert.setMessage(msg);
        }
    }

    @Override
    public void dismissProgress() {
        if (mDialogAlert != null && !mDialogAlert.isHidden()) {
            mDialogAlert.dismiss();
        }
    }

    @Override
    public void onCancel(DialogFragment v) {

    }

    @Override
    public void onSure(DialogFragment v, int white) {

    }

    @Override
    public void onError(DialogFragment v, String str) {

    }

    @Override
    public void onDismiss(DialogFragment v) {

    }

    protected abstract int getLayout();
}

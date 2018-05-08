package com.example.mvpreaderjava.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.mvpreaderjava.mvp.BaseView;
import com.example.mvpreaderjava.ui.widget.EmptyLayout;
import com.orhanobut.logger.Logger;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by sw116 on 2018/4/19.
 */

public abstract class SimpleFragment<A extends Serializable> extends SupportFragment implements BaseView {

    Unbinder mUnbinder;

    protected A mArgument;

    protected static String ARGS_KEY = "argument";

    private boolean hasArgument = false;

    private EmptyLayout emptyLayout;

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
        if (emptyLayout != null) {
            emptyLayout.showLoading();
        }
    }

    @Override
    public void error() {
        showToast("error");
        if (emptyLayout != null) {
            emptyLayout.showError();
        }
    }

    @Override
    public void content() {
        if (emptyLayout != null) {
            emptyLayout.hide();
        }
    }

    @Override
    public void empty() {
        if (emptyLayout != null) {
            emptyLayout.showEmpty();
        }
    }

    @Override
    public void complete() {
        Logger.d("state complete");
        if (emptyLayout != null) {
            emptyLayout.hide();
        }
    }

    @Override
    public void progress() {

    }

    @Override
    public void dismissProgress() {

    }

    protected abstract int getLayout();
}

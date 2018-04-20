package com.example.mvpreaderjava.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;


import com.example.mvpreaderjava.mvp.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by sw116 on 2018/4/19.
 * 基础视图activity
 */
public abstract class SimpleActivity extends SupportActivity implements BaseView {

    protected Activity mActivity;

    protected Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnbinder = ButterKnife.bind(this);
        mActivity = this;
        onViewCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void error() {

    }

    @Override
    public void loading() {

    }

    @Override
    public void content() {

    }

    //获取视图ID
    protected abstract int getLayout();

    protected abstract void onViewCreated();

}

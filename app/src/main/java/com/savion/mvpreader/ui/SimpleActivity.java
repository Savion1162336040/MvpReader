package com.savion.mvpreader.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.sw.mvp.view.IBaseView;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by savion on 2018/4/9.
 * 基础activity，负责管理基础view相关
 */
public abstract class SimpleActivity extends SupportActivity implements IBaseView {

    Unbinder unbinder;

    Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        activity = this;
        //view创建完成
        onViewCreated();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void showToast(@NotNull String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(@NotNull String str) {
        showToast(str);
    }

    @Override
    public void showLoading() {
        showToast("loading...");
    }


    @Override
    public void dismissLoading() {
        showToast("dismissLoading...");
    }

    @NotNull
    @Override
    public Context getIContext() {
        return activity;
    }

    protected abstract int getLayout();

    protected abstract void onViewCreated();

}

package com.savion.mvpreader.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sw.mvp.view.IBaseView;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by savion on 2018/4/9.
 */

public abstract class SimpleFragment extends SupportFragment implements IBaseView {

    Activity activity;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(view);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        onLazyLoad();
    }

    @Override
    public void showToast(@NotNull String str) {
        Toast.makeText(activity, str, Toast.LENGTH_LONG).show();
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

    protected abstract void onLazyLoad();

}

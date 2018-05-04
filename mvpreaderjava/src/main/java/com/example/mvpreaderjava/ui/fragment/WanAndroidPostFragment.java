package com.example.mvpreaderjava.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.mvp.contract.WanAndroidPostContract;
import com.example.mvpreaderjava.mvp.presenter.WanAndroidPostPresenter;
import com.example.mvpreaderjava.ui.base.BaseFragment;
import com.example.mvpreaderjava.ui.widget.EmptyLayout;

import butterknife.BindView;

/**
 * Created by sw116 on 2018/5/3.
 */

public class WanAndroidPostFragment extends BaseFragment<String, WanAndroidPostPresenter> implements WanAndroidPostContract.View {

    @BindView(R.id.post_recycler)
    protected RecyclerView recyclerView;
    @BindView(R.id.post_refresh)
    protected SwipeRefreshLayout refreshLayout;
    @BindView(R.id.post_emptylayout)
    protected EmptyLayout emptyLayout;

    @Override
    protected void inject() {
        getComponent().inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpEmptyLayout(emptyLayout);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        loading();
        mPresenter.getBanner();
        mPresenter.getPostList(0);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_wan_android_post;
    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void collected() {

    }

    @Override
    public void unCollected() {

    }
}

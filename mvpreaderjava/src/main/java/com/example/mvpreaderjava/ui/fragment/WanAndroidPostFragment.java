package com.example.mvpreaderjava.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidBanner;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidPost;
import com.example.mvpreaderjava.mvp.contract.WanAndroidPostContract;
import com.example.mvpreaderjava.mvp.presenter.WanAndroidPostPresenter;
import com.example.mvpreaderjava.ui.adapter.HomePostAdapter;
import com.example.mvpreaderjava.ui.base.BaseFragment;
import com.example.mvpreaderjava.ui.widget.EmptyLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observable;

/**
 * Created by sw116 on 2018/5/3.
 */

public class WanAndroidPostFragment extends BaseFragment<String, WanAndroidPostPresenter> implements WanAndroidPostContract.View, BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.post_recycler)
    protected RecyclerView recyclerView;
    @BindView(R.id.post_refresh)
    protected SwipeRefreshLayout refreshLayout;
    @BindView(R.id.post_emptylayout)
    protected EmptyLayout emptyLayout;
    protected HomePostAdapter adapter;
    protected List<WanAndroidPost> posts = new ArrayList<>();

    @Override
    protected void inject() {
        getComponent().inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpEmptyLayout(emptyLayout);
        refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        loading();
        adapter = new HomePostAdapter(R.layout.adapter_wan_android_home_post, posts);
        adapter.setOnItemChildClickListener(this);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
        mPresenter.getBanner();
        mPresenter.getPostList(0);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_wan_android_post;
    }

    @Override
    public void refresh() {
        mPresenter.getBanner();
        mPresenter.getPostList(0);
    }

    @Override
    public void loadMore() {
    }

    @Override
    public void showData(List<WanAndroidPost> data) {
        refreshLayout.setRefreshing(false);
        posts.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showBanner(List<WanAndroidBanner> banners) {

    }

    @Override
    public void collected(int id) {
        Observable.fromIterable(posts)
                .filter(wanAndroidPost -> wanAndroidPost.getId() == id)
                .doOnNext(wanAndroidPost -> {
                    wanAndroidPost.setCollect(true);
                    adapter.notifyDataSetChanged();
                })
                .subscribe();
    }

    @Override
    public void unCollected(int id) {
        Observable.fromIterable(posts)
                .filter(wanAndroidPost -> wanAndroidPost.getId() == id)
                .doOnNext(wanAndroidPost -> {
                    wanAndroidPost.setCollect(false);
                    adapter.notifyDataSetChanged();
                })
                .subscribe();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.adapter_home_post_type:
                showToast("go type");
                break;
            case R.id.adapter_home_post_like:
                if (view instanceof CheckBox) {
                    if (((CheckBox) view).isChecked()) {
                        mPresenter.unCollect(posts.get(position).getId());
                    } else {
                        mPresenter.collect(posts.get(position).getId());
                    }
                }
                break;
            case R.id.adapter_home_post_icon:
                showToast("go Author");
                break;
            case R.id.adapter_home_post_author:
                showToast("go Author too");
                break;
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onRefresh() {
        refresh();
    }
}

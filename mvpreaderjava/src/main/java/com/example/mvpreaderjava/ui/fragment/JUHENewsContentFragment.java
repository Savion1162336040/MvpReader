package com.example.mvpreaderjava.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.modle.bean.JUHE.JUHENewsData;
import com.example.mvpreaderjava.modle.bean.Tabs;
import com.example.mvpreaderjava.mvp.contract.JUHEContract;
import com.example.mvpreaderjava.mvp.presenter.JUHEPresenter;
import com.example.mvpreaderjava.ui.adapter.JUHENewsAdapter;
import com.example.mvpreaderjava.ui.base.BaseFragment;
import com.example.mvpreaderjava.ui.widget.EmptyLayout;
import com.savion.loadinglayout.LoadingLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JUHENewsContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JUHENewsContentFragment extends BaseFragment<Tabs, JUHEPresenter> implements JUHEContract.View, SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    @BindView(R.id.emptylayout)
    LoadingLayout emptyLayout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refreshLayout;
    private RecyclerView.Adapter adapter;
    private List<JUHENewsData> dataList;

    public JUHENewsContentFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment JUHENewsContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JUHENewsContentFragment newInstance(Tabs param1) {
        JUHENewsContentFragment fragment = new JUHENewsContentFragment();
        fragment.setMArgument(param1);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setUpEmptyLayout(emptyLayout);
        setUpEmptyView(emptyLayout);
        refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        dataList = new ArrayList<>();
        adapter = new JUHENewsAdapter(R.layout.adapter_juhe_news, dataList);
        recyclerView.setAdapter(adapter);
        Tabs tabs = getMArgument();
        mPresenter.getNews(tabs.getType());
    }

    @Override
    protected void inject() {
        getComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_juhenews_content;
    }


    @Override
    public void refreshData(List<JUHENewsData> juheNewsResponse) {
        dataList.clear();
        loadMoreData(juheNewsResponse);
    }

    @Override
    public void loadMoreData(List<JUHENewsData> juheNewsResponse) {
        refreshLayout.setRefreshing(false);
        dataList.addAll(juheNewsResponse);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        mPresenter.getNews(getMArgument().getType());
    }
}

package com.savion.mvpreader.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.savion.mvpreader.Constant;
import com.savion.mvpreader.R;
import com.savion.mvpreader.adapter.NewsContentItemAdapter;
import com.savion.mvpreader.bean.News;
import com.savion.mvpreader.bean.Tab;
import com.savion.mvpreader.presenter.NewsMessagePresenter;
import com.savion.mvpreader.view.NewsMessageView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsContentFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, NewsMessageView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private Tab mParam2;

    private SwipeRefreshLayout refreshLayout;

    private NewsMessagePresenter presenter;

    private NewsContentItemAdapter newsContentItemAdapter;

    private List<News> newsList;

    public NewsContentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsContentFragment newInstance(String param1, Tab param2) {
        NewsContentFragment fragment = new NewsContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putSerializable(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = (Tab) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_content, container, false);

        refreshLayout = view.findViewById(R.id.news_content_swiperefresh);
        TextView textView = view.findViewById(R.id.news_content_title);
        RecyclerView recyclerView = view.findViewById(R.id.news_content_recyclerview);
        textView.setText(mParam1);

        newsList = new ArrayList<>();
        newsContentItemAdapter = new NewsContentItemAdapter(getActivity(), newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(newsContentItemAdapter);
        refreshLayout.setOnRefreshListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = new NewsMessagePresenter();
        presenter.attachView(this);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        presenter.dettachView();
    }

    @Override
    void initData(boolean showLoading) {
        Log.w(Constant.TAG, String.format("initData:%s,%s", showLoading, mParam1));
        //presenter.getNewsMessage();
        if (showLoading)
            refreshStart();
        initPresenteData();
    }

    @Override
    public void onRefresh() {
        initData(true);
    }

    @Override
    public void showToast(@NotNull String str) {
        Snackbar.make(refreshLayout, String.format("showToas:%s", str), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(@NotNull String str) {
        showToast(String.format("showError:%s", str));
    }

    @Override
    public void showLoading() {
        showToast(String.format("showLoading..."));
    }

    @Override
    public void dismissLoading() {
        showToast(String.format("dismissLoading..."));
    }

    @NotNull
    @Override
    public Context getIContext() {
        return getActivity();
    }

    @Override
    public void initPresenteData() {
        presenter.getNewsMessage("top");
    }

    @Override
    public void notifyData(List<News> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        if (newsContentItemAdapter != null)
            newsContentItemAdapter.notifyDataSetChanged();
    }

    @Override
    public void refreshStart() {
        if (refreshLayout != null)
            refreshLayout.setRefreshing(true);
    }

    @Override
    public void refreshCompelete() {
        if (refreshLayout != null)
            refreshLayout.setRefreshing(false);
    }
}

package com.savion.mvpreader.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.savion.mvpreader.R;
import com.savion.mvpreader.adapter.NewsContentItemAdapter;
import com.savion.mvpreader.model.bean.News;
import com.savion.mvpreader.model.bean.Tab;
import com.savion.mvpreader.contract.NewsMessageContract;
import com.savion.mvpreader.presenter.NewsMessagePresenter;
import com.savion.mvpreader.ui.BaseFragment;
import com.savion.mvpreader.ui.bind.OnSwipeRefresh;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsContentFragment extends BaseFragment<NewsMessagePresenter> implements NewsMessageContract.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private Tab mParam2;
    @BindView(R.id.news_content_swiperefresh)
    protected SwipeRefreshLayout refreshLayout;
    @BindView(R.id.news_content_recyclerview)
    protected RecyclerView recyclerView;
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

    @OnSwipeRefresh(value = R.id.news_content_swiperefresh)
    public void onRefresh() {
        initPresenteData();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsList = new ArrayList<>();
        newsContentItemAdapter = new NewsContentItemAdapter(getActivity(), newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(newsContentItemAdapter);
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_news_content;
    }

    @Override
    protected void onLazyLoad() {
        refreshStart();
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

    @Override
    protected void inject() {
        getComponent().inject(this);
    }
}

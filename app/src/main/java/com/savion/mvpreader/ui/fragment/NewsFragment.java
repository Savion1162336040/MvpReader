package com.savion.mvpreader.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.savion.mvpreader.R;
import com.savion.mvpreader.adapter.NewsFragmentAdapter;
import com.savion.mvpreader.model.bean.Tab;
import com.savion.mvpreader.contract.NewsMainContract;
import com.savion.mvpreader.presenter.NewsMainPresenter;
import com.savion.mvpreader.ui.BaseFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends BaseFragment<NewsMainPresenter> implements NewsMainContract.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private Tab mParam2;
    @BindView(R.id.news_pager)
    protected ViewPager viewPager;
    @BindView(R.id.news_tablayout)
    protected TabLayout tabLayout;
    private NewsFragmentAdapter newsFragmentAdapter;

    List<Tab> list = new ArrayList<>();

    public NewsFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, Tab param2) {
        NewsFragment fragment = new NewsFragment();
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //new FragmentPagerAdapter(fragmentManager)的FragmentManager，一定要保证正确，
        // 如果ViewPager是Activity内的控件，则传递getSupportFragmentManager()
        // 如果是Fragment的控件中，则应该传递getChildFragmentManager()。
        // 只要记住ViewPager内的Fragments是当前组件的子Fragment这个原则即可。
        //此处NewsFragment是Fragment所以使用getChildFragmentManager使用Fragment内部的FragmentManager
        newsFragmentAdapter = new NewsFragmentAdapter(getChildFragmentManager(), list);
        viewPager.setAdapter(newsFragmentAdapter);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void changeTabs(@NotNull String tag) {
    }

    @Override
    public void loadTabs(List<Tab> tab) {
        list.clear();
        for (Tab tab1 : tab) {
            addTab(tab1);
            addTabTop(tab1.getTag());
        }
        newsFragmentAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadTabTops(List<String> title) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void onLazyLoad() {
        // TODO: 2018/4/9 懒加载数据初始化
        presenter.getTabs();
    }

    @Override
    public void addTab(@NotNull Tab tab) {
//        Fragment fragment = NewsContentFragment.newInstance(tab.getTag(), tab);
//        list.add(fragment);
        newsFragmentAdapter.addTab(tab);
    }

    @Override
    public void addTabTop(@NotNull String title) {
        //tabLayout.addTab(tabLayout.newTab().setTag(title).setText(title));
    }

    @Override
    protected void inject() {
        getComponent().inject(this);
    }
}

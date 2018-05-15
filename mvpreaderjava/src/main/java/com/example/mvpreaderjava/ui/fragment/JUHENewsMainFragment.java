package com.example.mvpreaderjava.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.modle.bean.Tabs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link JUHENewsMainFragment.FragmentCallback} interface
 * to handle interaction events.
 * Use the {@link JUHENewsMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JUHENewsMainFragment extends BaseMainFragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "tag";
    @BindView(R.id.juhe_main_toolbar)
    Toolbar toolbar;
    @BindView(R.id.juhe_main_viewpager)
    ViewPager viewPager;
    @BindView(R.id.juhe_main_tab)
    TabLayout tabLayout;
    Gson gson = new Gson();

    public JUHENewsMainFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param tag Parameter 2.
     * @return A new instance of fragment JUHENewsMainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JUHENewsMainFragment newInstance(String tag) {
        JUHENewsMainFragment fragment = new JUHENewsMainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, tag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupToolbar(toolbar,"聚合数据");
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new TabAdapter(getChildFragmentManager()));
    }

    private List<Tabs> getTabs() {
        List<Tabs> tabsList = new ArrayList<>();
        String[] tabs = getResources().getStringArray(R.array.juhe_tab);
        for (int i = 0; i < tabs.length; i++) {
            Type type = new TypeToken<Tabs>() {
            }.getType();
            Tabs tabs1 = gson.fromJson(tabs[i], type);
            tabsList.add(tabs1);
        }
        return tabsList;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_juhenews_main;
    }

    class TabAdapter extends FragmentPagerAdapter {

        List<Tabs> tabs;
        List<Fragment> fragments;

        public TabAdapter(FragmentManager fm) {
            super(fm);
            tabs = getTabs();
            fragments = new ArrayList<>();
            for (int i = 0; i < tabs.size(); i++) {
                fragments.add(JUHENewsContentFragment.newInstance(tabs.get(i)));
            }
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position).getTitle();
        }
    }
}


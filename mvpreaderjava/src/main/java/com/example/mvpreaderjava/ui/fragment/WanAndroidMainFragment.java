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

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WanAndroidMainFragment.FragmentCallback} interface
 * to handle interaction events.
 * Use the {@link WanAndroidMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WanAndroidMainFragment extends BaseMainFragment {
    @BindView(R.id.wan_android_main_toolbar)
    Toolbar toolbar;
    @BindView(R.id.wan_android_main_viewpager)
    ViewPager viewPager;
    @BindView(R.id.wan_android_main_tab)
    TabLayout tabLayout;
    Gson gson = new Gson();

    String[] tabs = {"文章"};

    public WanAndroidMainFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment JUHENewsMainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WanAndroidMainFragment newInstance() {
        WanAndroidMainFragment fragment = new WanAndroidMainFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupToolbar(toolbar);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new WanAndroidPostFragment());
        viewPager.setAdapter(new TabAdapter(getChildFragmentManager(), fragments, tabs));

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_wan_android_main;
    }

    class TabAdapter extends FragmentPagerAdapter {

        List<Fragment> fragments;
        String[] tab;

        public TabAdapter(FragmentManager fm, List<Fragment> fragments, String[] tabs) {
            super(fm);
            this.fragments = fragments;
            this.tab = tabs;
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
            if (position < tab.length) {
                return tab[position];
            }
            return super.getPageTitle(position);
        }
    }

}

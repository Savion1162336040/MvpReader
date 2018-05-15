package com.example.mvpreaderjava.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * fragmentpager adapter
 */
public class CommomPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments = new ArrayList<>();
    List<String> tabs;

    public CommomPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        this(fm, fragments, null);
    }

    public CommomPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> tabs) {
        super(fm);
        this.fragments = fragments;
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs != null && tabs.size() > position ? tabs.get(position) : "";
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }
}

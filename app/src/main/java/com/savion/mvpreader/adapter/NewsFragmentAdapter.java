package com.savion.mvpreader.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.savion.mvpreader.Constant;
import com.savion.mvpreader.bean.Tab;
import com.savion.mvpreader.fragment.NewsContentFragment;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-12-29.
 */

public class NewsFragmentAdapter extends FragmentPagerAdapter {

    private List<Tab> tabList;
    private List<Fragment> fragmentList;
    private final FragmentManager fragmentManager;

    public NewsFragmentAdapter(FragmentManager fm, List<Tab> fragmentMap) {
        super(fm);
        this.fragmentManager = fm;
        this.tabList = fragmentMap;
        formatFragments();
    }

    private void formatFragments() {
        fragmentList.clear();
        for (Tab tab : tabList) {
            if (tab.enable()) {
                addFragment(tab);
            }
        }
    }

    private void addFragment(Tab tab) {
        Fragment fragment = NewsContentFragment.newInstance(tab.getTag(), tab);
        fragmentList.add(fragment);
    }

    public void addTabs(List<Tab> tabs) {
        tabList.addAll(tabs);
        formatFragments();
    }

    public void addTab(Tab tab) {
        tabList.add(tab);
        formatFragments();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getCount() {
        return Math.min(fragmentList.size(), tabList.size());
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.e(Constant.TAG, String.format("instantiateItem: position = %s", position));
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.e(Constant.TAG, String.format("destroyItem: position = %s,object = %s", position, object.toString()));
        super.destroyItem(container, position, object);
    }
}

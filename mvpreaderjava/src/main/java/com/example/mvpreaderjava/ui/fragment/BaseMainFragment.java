package com.example.mvpreaderjava.ui.fragment;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.ui.base.BaseFragment;
import com.example.mvpreaderjava.ui.base.SimpleFragment;

/**
 * Created by sw116 on 2018/4/20.
 */

public abstract class BaseMainFragment extends SimpleFragment {

    protected FragmentCallback fragmentCallback;
    protected AppCompatActivity appCompatActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof FragmentCallback)) {
            throw new ClassCastException("Activity must implements BaseMainFragment.FragmentCallback");
        }
        if (!(activity instanceof AppCompatActivity)) {
            throw new ClassCastException("Activity must extends from AppcompatActivity");
        }
        fragmentCallback = (FragmentCallback) activity;
        appCompatActivity = (AppCompatActivity) activity;
    }

    protected void setupToolbar(Toolbar toolbar,String title) {
        appCompatActivity.setSupportActionBar(toolbar);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        appCompatActivity.getSupportActionBar().setHomeButtonEnabled(true);
        appCompatActivity.getSupportActionBar().setTitle(title);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(appCompatActivity, fragmentCallback.getDrawer(), toolbar, R.string.drawer_open_des,
                R.string.drawer_close_des);
        mDrawerToggle.syncState();
        fragmentCallback.getDrawer().addDrawerListener(mDrawerToggle);
    }

    public interface FragmentCallback {
        void openDrawer(boolean open);

        DrawerLayout getDrawer();
    }
}

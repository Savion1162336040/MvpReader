package com.example.mvpreaderjava.ui.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.RxUtils;
import com.example.mvpreaderjava.ui.base.SimpleActivity;
import com.example.mvpreaderjava.ui.fragment.BaseMainFragment;
import com.example.mvpreaderjava.ui.fragment.JUHENewsMainFragment;
import com.example.mvpreaderjava.ui.fragment.ListFragmentOne;
import com.example.mvpreaderjava.ui.fragment.WanAndroidMainFragment;
import com.orhanobut.logger.Logger;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by sw116 on 2018/4/19.
 */

public class MainActivity extends SimpleActivity implements BaseMainFragment.FragmentCallback, NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.main_drawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.main_framelayout)
    FrameLayout frameLayout;
    @BindView(R.id.main_navigation)
    NavigationView navigationView;

    JUHENewsMainFragment fragmentImg;
    WanAndroidMainFragment fragmentWanA;

    SupportFragment showFragment;
    SupportFragment hideFragment;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    private void initFragment() {
        fragmentImg = JUHENewsMainFragment.newInstance("juhe");
        fragmentWanA = WanAndroidMainFragment.newInstance();

        //fragmentNews = ListFragmentOne.newInstance("FragmentNews");
        showFragment = fragmentImg;
        hideFragment = null;
        navigationView.setCheckedItem(R.id.main_drawer_action_pic);
        loadMultipleRootFragment(R.id.main_framelayout, 0, fragmentImg, fragmentWanA);
    }

    @Override
    protected void onViewCreated() {
        navigationView.setNavigationItemSelectedListener(this);
        initFragment();
        synsFragmentState(fragmentImg);
    }

    /**
     * 同步显示隐藏fragment状态
     *
     * @param thisFragment
     */
    private void synsFragmentState(SupportFragment thisFragment) {
        showFragment = thisFragment;
        showHideFragment(showFragment, hideFragment);
        hideFragment = showFragment;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_drawer_action_pic:
                synsFragmentState(fragmentImg);
                break;
            case R.id.main_drawer_action_news:
                synsFragmentState(fragmentWanA);
                break;
            case R.id.main_drawer_action_coming:
                showToast("coming soon...");
                break;
            case R.id.main_drawer_action_test:
                startActivity(new Intent(this, TestActivity.class));
                break;
        }
        drawerLayout.closeDrawer(Gravity.LEFT);
        return true;
    }

    private void getPackageinfo(int flag) {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), flag);
            Logger.wtf("getPackageInfo success:%s", packageInfo.toString());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Logger.e("getPackageInfo Exception:%s", e.getMessage());
        }
    }

    @Override
    public void openDrawer(boolean open) {
        if (open)
            drawerLayout.openDrawer(Gravity.LEFT);
        else
            drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public DrawerLayout getDrawer() {
        return drawerLayout;
    }

}

package com.example.mvpreaderjava.ui.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.RxJavaTest;
import com.example.mvpreaderjava.ui.base.SimpleActivity;
import com.example.mvpreaderjava.ui.fragment.BaseMainFragment;
import com.example.mvpreaderjava.ui.fragment.JUHENewsMainFragment;
import com.example.mvpreaderjava.ui.fragment.ListFragmentOne;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
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
    RxJavaTest rxJavaTest = new RxJavaTest();

    SupportFragment fragmentImg;

    SupportFragment showFragment;
    SupportFragment hideFragment;
//    @BindView(R.id.main_coordinator)
//    CoordinatorLayout coordinatorLayout;
//    @BindView(R.id.main_appbarlayout)
//    AppBarLayout appBarLayout;
//    @BindView(R.id.main_toolbar)
//    Toolbar toolbar;
//    @BindView(R.id.main_tablayout)
//    TabLayout tabLayout;
//    @BindView(R.id.main_viewpager)
//    ViewPager viewPager;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    private void initFragment() {
        fragmentImg = JUHENewsMainFragment.newInstance("juhe");
        //fragmentNews = ListFragmentOne.newInstance("FragmentNews");
        showFragment = fragmentImg;
        hideFragment = null;
        navigationView.setCheckedItem(R.id.main_drawer_action_pic);
        loadMultipleRootFragment(R.id.main_framelayout, 0, fragmentImg);
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
                showToast("coming soon...");
                break;
            case R.id.main_drawer_action_coming:
                showToast("coming soon...");
                break;
            case R.id.main_drawer_action_activities:
                getPackageinfo(PackageManager.GET_ACTIVITIES);
                break;
            case R.id.main_drawer_action_filter:
                getPackageinfo(PackageManager.GET_INTENT_FILTERS);
                break;
            case R.id.main_drawer_action_instrumentation:
                getPackageinfo(PackageManager.GET_INSTRUMENTATION);
                break;
            case R.id.main_drawer_action_providers:
                getPackageinfo(PackageManager.GET_PROVIDERS);
                break;
            case R.id.main_drawer_action_receivers:
                getPackageinfo(PackageManager.GET_RECEIVERS);
                break;
            case R.id.main_drawer_action_signatures:
                getPackageinfo(PackageManager.GET_SIGNATURES);
                break;
            case R.id.main_drawer_action_flatmap:
                rxJavaTest.flatMap();
                break;
            case R.id.main_drawer_action_concatmap:
                rxJavaTest.concatMap();
                break;
        }
        drawerLayout.closeDrawer(Gravity.LEFT);
        return true;
    }

    private void getPackageinfo(int flag){
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(),flag);
            Logger.wtf("getPackageInfo success:%s",packageInfo.toString());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Logger.e("getPackageInfo Exception:%s",e.getMessage());
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    class MyPageAdapter extends FragmentPagerAdapter {

        String[] pages = {"Page1", "Page2"};
        List<Fragment> fragments = new ArrayList<>();

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
            for (String s : pages) {
                Bundle bundle = new Bundle();
                bundle.putString("tag", s);
                fragments.add(ListFragmentOne.newInstance(bundle));
            }
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments != null ? fragments.size() : 0;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragments.get(position).getArguments().getString("tag");
        }

    }
}

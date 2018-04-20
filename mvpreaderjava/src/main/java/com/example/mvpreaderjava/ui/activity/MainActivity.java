package com.example.mvpreaderjava.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.ui.base.SimpleActivity;
import com.example.mvpreaderjava.ui.bind.OnNavigationSelected;
import com.example.mvpreaderjava.ui.fragment.ListFragmentOne;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by sw116 on 2018/4/19.
 */

public class MainActivity extends SimpleActivity {
    @BindView(R.id.main_drawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.main_framelayout)
    FrameLayout frameLayout;
    @BindView(R.id.main_navigation)
    NavigationView navigationView;

    SupportFragment fragmentImg;
    SupportFragment fragmentNews;

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
        fragmentImg = ListFragmentOne.newInstance("FragmentImg");
        fragmentNews = ListFragmentOne.newInstance("FragmentNews");
        showFragment = fragmentImg;
        hideFragment = null;
    }

    @Override
    protected void onViewCreated() {
        initFragment();
        synsFragmentState(fragmentImg);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_more);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open_des, R.string.drawer_close_des);
//        drawerToggle.syncState();
//        drawerLayout.addDrawerListener(drawerToggle);
//
//        tabLayout.setupWithViewPager(viewPager);

//        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));

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

    @OnNavigationSelected(value = {R.id.main_navigation})
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_drawer_action_pic:
                synsFragmentState(fragmentImg);
                break;
            case R.id.main_drawer_action_news:
                synsFragmentState(fragmentNews);
                break;
            case R.id.main_drawer_action_coming:
                showToast("coming soon...");
                break;
        }
        drawerLayout.closeDrawer(Gravity.LEFT);
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

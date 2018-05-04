package com.savion.mvpreader.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.savion.mvpreader.R;
import com.savion.mvpreader.RxJavaTest;
import com.savion.mvpreader.model.bean.Tab;
import com.savion.mvpreader.contract.MainActivityContract;
import com.savion.mvpreader.presenter.MainActivityPresenter;
import com.savion.mvpreader.ui.BaseActivity;
import com.savion.mvpreader.ui.bind.OnNavigationSelected;
import com.savion.mvpreader.ui.fragment.NewsFragment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityContract.View {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer)
    protected DrawerLayout drawerLayout;
    @BindView(R.id.contentFrame)
    protected FrameLayout frameLayout;
    @BindView(R.id.main_drawer_navigation)
    protected NavigationView navigationView;
    Fragment fragment;
    Map<String, Fragment> mapFragment = new HashMap<>();


    @Override
    protected void inject() {
        getComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpToolbar();
    }

    @OnNavigationSelected(R.id.main_drawer_navigation)
    boolean onNavigationSelected(MenuItem item) {
        item.setChecked(true);
        drawerLayout.closeDrawers();
        switch (item.getItemId()){
            case R.id.main_drawer_action_flatmap:
                RxJavaTest test = new RxJavaTest();
                test.flatMap();
                break;
            case R.id.main_drawer_action_news:
            case R.id.main_drawer_action_pic:
            case R.id.main_drawer_action_coming:
                transforFragment(item.getTitle().toString());
                break;
        }
        return true;
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_more);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open_des, R.string.drawer_close_des);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
    }

    @Override
    public void openDrawer() {
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    @Override
    public void transforFragment(String index) {
        if (mapFragment != null) {
            Iterator<String> iterator1 = mapFragment.keySet().iterator();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            while (iterator1.hasNext()) {
                String fragment = iterator1.next();
                if (mapFragment.get(fragment) != null && !mapFragment.get(fragment).isDetached()) {
                    if (TextUtils.equals(index, fragment)) {
                        fragmentTransaction.show(mapFragment.get(fragment));
                    } else {
                        fragmentTransaction.hide(mapFragment.get(fragment));
                    }
                }
            }
            fragmentTransaction.commit();
        }
    }

    @Override
    public void loadTabs(List<Tab> tabs) {
        if (tabs != null && tabs.size() > 0) {
            String aboutToShow = tabs.get(0).getTag();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            for (Tab t : tabs) {
                Fragment fragment = NewsFragment.newInstance(t.getTag(), t);
                fragmentTransaction.add(R.id.contentFrame, fragment, t.getTag());
                mapFragment.put(t.getTag(), fragment);
            }
            fragmentTransaction.commit();
            transforFragment(aboutToShow);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawers();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

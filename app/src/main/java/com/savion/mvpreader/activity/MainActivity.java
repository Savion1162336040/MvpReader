package com.savion.mvpreader.activity;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.savion.mvpreader.Constant;
import com.savion.mvpreader.R;
import com.savion.mvpreader.bean.Tab;
import com.savion.mvpreader.fragment.NewsFragment;
import com.savion.mvpreader.presenter.MainPresenter;
import com.savion.mvpreader.view.MainActivityView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainActivityView, NewsFragment.OnFragmentInteractionListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    FrameLayout frameLayout;
    Fragment fragment;
    Map<String, Fragment> mapFragment = new HashMap<>();

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.contentFrame);
        setUpDrawer();
        setUpToolbar();
        presenter = new MainPresenter();
        presenter.attachView(this);
        presenter.getTabs();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }

    private void setUpDrawer() {
        drawerLayout = findViewById(R.id.drawer);
        final NavigationView navigationView = findViewById(R.id.main_drawer_navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //setitem selected
                item.setChecked(true);
                transforFragment(item.getTitle().toString());
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void setUpToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_more);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open_des, R.string.drawer_close_des);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
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
    public void onFragmentInteraction(Uri uri) {
        openDrawer();
    }

    @Override
    public void loadTabs(@NotNull ArrayList<Tab> tabs) {
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
    public void showToast(@NotNull String str) {
        Snackbar.make(drawerLayout, str, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(@NotNull String str) {
        showToast(String.format("showError:%s", str));
    }

    @Override
    public void showLoading() {
        showToast("showLoading...");
    }

    @Override
    public void dismissLoading() {
        showToast("dissmissLoading...");
    }

    @NotNull
    @Override
    public Context getIContext() {
        return this;
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

package com.savion.mvpreader.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.savion.mvpreader.R;
import com.savion.mvpreader.presenter.IBasePresenter;
import com.savion.mvpreader.view.MainActivityView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.contentFrame);
        setUpDrawer();
        setUpToolbar();
    }

    private void setUpDrawer() {
        drawerLayout = findViewById(R.id.drawer);
        final NavigationView navigationView = findViewById(R.id.main_drawer_navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main_drawer_action_coming:
                        Snackbar.make(navigationView, "coming soon...", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.main_drawer_action_news:
                        Snackbar.make(navigationView, "news coming soon...", Snackbar.LENGTH_SHORT).show();
                        break;
                }
                //setitem selected
                item.setChecked(true);
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
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open_des,R.string.drawer_close_des);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void transportFragment(){

    }

    @Override
    public void openDrawer() {
        drawerLayout.opendra
    }

    @Override
    public void transforFragment(int index) {

    }

    @Override
    public void setPresenter(@NotNull IBasePresenter presenter) {

    }
}

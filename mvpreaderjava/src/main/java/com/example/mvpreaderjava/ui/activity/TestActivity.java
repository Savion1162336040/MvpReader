package com.example.mvpreaderjava.ui.activity;

import android.view.View;
import android.widget.Button;

import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.ui.base.SimpleActivity;
import com.savion.loadinglayout.LoadingLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class TestActivity extends SimpleActivity {
    @BindView(R.id.empty)
    Button empty;
    @BindView(R.id.error)
    Button error;
    @BindView(R.id.loading)
    Button loading;
    @BindView(R.id.content)
    Button content;
    @BindView(R.id.loadinglayout)
    LoadingLayout loadingLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_test;
    }

    @Override
    protected void onViewCreated() {

    }

    @OnClick(value = {R.id.empty,R.id.error,R.id.loading})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.empty:
                loadingLayout.showEmpty();
                break;
            case R.id.error:
                loadingLayout.showError();
                break;
            case R.id.loading:
                loadingLayout.showLoading();
                break;
            case R.id.content:
                loadingLayout.showContent();
                break;
        }
    }
}

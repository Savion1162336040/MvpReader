package com.example.mvpreaderjava.mvp;

/**
 * Created by sw116 on 2018/4/19.
 */

public interface BaseView {
    //显示提示
    void showToast(String msg);
    //显示加载页面
    void loading();
    //显示加载错误页面
    void error();
    //显示加载完成页面
    void content();
    void empty();
    void complete();

    void progress();
    void dismissProgress();
}

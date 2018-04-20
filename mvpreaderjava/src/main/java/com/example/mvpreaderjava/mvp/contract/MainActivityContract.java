package com.example.mvpreaderjava.mvp.contract;

import com.example.mvpreaderjava.mvp.BasePresenter;
import com.example.mvpreaderjava.mvp.BaseView;

/**
 * Created by sw116 on 2018/4/19.
 */

public class MainActivityContract {

    public interface Presenter<V extends BaseView> extends BasePresenter<V> {

        void getTabs();

    }

    public interface View extends BaseView {
        void openDrawer();

        void transforFragment(String fragment);

    }

}

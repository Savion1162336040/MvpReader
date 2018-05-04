package com.example.mvpreaderjava.mvp.contract;

import com.example.mvpreaderjava.modle.bean.JUHE.JUHENewsData;
import com.example.mvpreaderjava.mvp.BasePresenter;
import com.example.mvpreaderjava.mvp.BaseView;

import java.util.List;

/**
 * Created by sw116 on 2018/4/24.
 */

public class JUHEContract {
    public interface View extends BaseView {
        void refreshData(List<JUHENewsData> juheNewsResponse);

        void loadMoreData(List<JUHENewsData> juheNewsResponse);
    }

    public interface Presenter<V extends BaseView> extends BasePresenter<V> {
        void getNews(String type);
    }
}

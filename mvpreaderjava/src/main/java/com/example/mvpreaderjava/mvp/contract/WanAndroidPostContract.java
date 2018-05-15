package com.example.mvpreaderjava.mvp.contract;

import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidBanner;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidPost;
import com.example.mvpreaderjava.mvp.BasePresenter;
import com.example.mvpreaderjava.mvp.BaseView;

import java.util.List;

/**
 * Created by sw116 on 2018/5/3.
 */
public class WanAndroidPostContract {
    public interface View extends BaseView {
        //刷新
        void refresh();
        //加载更多
        void loadMore();
        void showData(List<WanAndroidPost> data);
        void showBanner(List<WanAndroidBanner> banners);
        //收藏
        void collected(int id,boolean collected);
    }

    public interface Presenter<V extends BaseView> extends BasePresenter<V> {
        //获取banner
        void getBanner();
        //获取首页文章列表
        void getPostList(int page);
        //获取文章与banner
        void getData(int postpage);
        //收藏站内文章
        void collect(int id,boolean collect);
    }
}

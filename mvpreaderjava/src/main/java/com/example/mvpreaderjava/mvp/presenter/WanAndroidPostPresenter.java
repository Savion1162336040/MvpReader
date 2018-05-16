package com.example.mvpreaderjava.mvp.presenter;

import com.example.mvpreaderjava.CommomSubscriber;
import com.example.mvpreaderjava.RxUtils;
import com.example.mvpreaderjava.modle.DataManager;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidBanner;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidData;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidPost;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidResponse;
import com.example.mvpreaderjava.modle.exception.DataEmptyException;
import com.example.mvpreaderjava.mvp.RxPresenter;
import com.example.mvpreaderjava.mvp.contract.WanAndroidPostContract;
import com.example.mvpreaderjava.ui.widget.DialogAlert;

import org.reactivestreams.Publisher;

import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sw116 on 2018/5/3.
 */

public class WanAndroidPostPresenter extends RxPresenter<WanAndroidPostContract.View> implements WanAndroidPostContract.Presenter<WanAndroidPostContract.View> {

    private DataManager dataManager;

    @Inject
    public WanAndroidPostPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getBanner() {
        add(dataManager.getBannerList()
                .compose(RxUtils.commonFlowableScheduler())
                .compose(RxUtils.handlerWanAndroidData())
                .flatMap(banners -> {
                    if (banners == null || banners.size() == 0)
                        return Flowable.error(new DataEmptyException("banner数据空"));
                    else
                        return RxUtils.createFlowable(banners);
                })
                .subscribeWith(new CommomSubscriber<List<WanAndroidBanner>>(view) {
                    @Override
                    public void onNext(List<WanAndroidBanner> bannerList) {
                        if (isAttached()) {
                            view.showBanner(bannerList);
                        }
                    }
                }));
    }

    @Override
    public void getPostList(int page) {
        add(dataManager.getMainPostList(page)
                .compose(RxUtils.commonFlowableScheduler())
                .compose(RxUtils.handlerWanAndroidData())
                .doOnSubscribe(subscription -> {
                    if (isAttached()) view.loading();
                })
                .flatMap((Function<WanAndroidData, Publisher<List<WanAndroidPost>>>) wanAndroidData -> {
                    //接口获取totle数据空
                    if (wanAndroidData.getTotal() == 0) {
                        return Flowable.error(new DataEmptyException("没有文章数据"));
                    } else {
                        if (wanAndroidData.getDatas() == null || wanAndroidData.getDatas().size() == 0)
                            return Flowable.error(new DataEmptyException("文章列表空"));
                        else
                            return RxUtils.createFlowable(wanAndroidData.getDatas());
                    }
                }).subscribeWith(new CommomSubscriber<List<WanAndroidPost>>(view, true) {
                    @Override
                    public void onNext(List<WanAndroidPost> wanAndroidData) {
                        if (isAttached()) {
                            view.dismissProgress();
                            view.showData(wanAndroidData);
                            view.content();
                        }
                    }
                }));

    }

    @Override
    public void getData(int postpage) {

    }


    @Override
    public void collect(int id, boolean collect) {
        add((collect ? dataManager.addCollectInner(id) : dataManager.unCollect(id))
                .compose(RxUtils.commonFlowableScheduler())
                .compose(RxUtils.handlerWanAndroidData())
                .doOnSubscribe(subscription -> {
                    if (isAttached())
                        view.progress("collecting...");
                })
                .subscribeWith(new CommomSubscriber<String>(view, false) {
                    @Override
                    public void onNext(String s) {
                        if (isAttached()) {
                            view.setProgressState(DialogAlert.STATE_SUCCESS, collect ? "collect success" : "uncollect success");
                            view.collected(id, collect);
                        }
                    }

                    @Override
                    protected void onHandleableError(Throwable t) {
                        if (isAttached()) {
                            view.setProgressState(DialogAlert.STATE_FAILED, collect ? "collect failed:" + t.getMessage() : "uncollect failed:" + t.getMessage());
                            view.collected(id, !collect);
                        }
                    }

                }));
    }
}

package com.example.mvpreaderjava.mvp.presenter;

import com.example.mvpreaderjava.CommomSubscriber;
import com.example.mvpreaderjava.RxUtils;
import com.example.mvpreaderjava.modle.DataManager;
import com.example.mvpreaderjava.modle.bean.JUHENewsData;
import com.example.mvpreaderjava.modle.bean.JUHENewsResponse;
import com.example.mvpreaderjava.modle.exception.ApiException;
import com.example.mvpreaderjava.mvp.BaseView;
import com.example.mvpreaderjava.mvp.RxPresenter;
import com.example.mvpreaderjava.mvp.contract.JUHEContract;
import com.orhanobut.logger.Logger;

import org.reactivestreams.Publisher;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * Created by sw116 on 2018/4/24.
 */

public class JUHEPresenter extends RxPresenter<JUHEContract.View> implements JUHEContract.Presenter<JUHEContract.View> {
    DataManager dataManager;

    @Inject
    public JUHEPresenter(DataManager helper) {
        this.dataManager = helper;
    }

    @Override
    public void getNews(String type) {
//        add(dataManager.getJuheNews(type).compose(RxUtils.commonFlowableScheduler()).doOnSubscribe(subscription -> {
//            view.loading();
//        }).subscribeWith(new CommomResourceScriber<List<JUHENewsResponse.Data>>(view, true) {
//            @Override
//            public void onNext(List<JUHENewsResponse.Data> data) {
//
//            }
//        }));
        dataManager.getJuheNews(type)
                .delay(3, TimeUnit.SECONDS)
                .compose(RxUtils.commonFlowableScheduler())
                .compose(RxUtils.handlerResult())
                .compose(RxUtils.handlerData())
                .doOnSubscribe(subscription -> view.loading())
                .subscribeWith(new CommomSubscriber<List<JUHENewsData>>(view, true) {
                    @Override
                    public void onNext(List<JUHENewsData> data) {
                        view.content();
                        view.loadMoreData(data);
                    }
                });
    }
}

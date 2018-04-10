package com.savion.mvpreader.common;

import com.savion.mvpreader.model.exception.ApiException;
import com.savion.mvpreader.model.response.JUHENewsResponse;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by savion on 2018/4/9.
 */

public class RxUtils {
    //统一线程调度flowable.compose(commonScheduler())
    public static <T> FlowableTransformer<T, T> commonFlowableScheduler() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };
    }

    //统一线程调度flowable.compose(commonScheduler())
    public static <T> ObservableTransformer<T, T> commonObserableScheduler() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };
    }

    public static <T> FlowableTransformer<JUHENewsResponse<T>, T> parseJUHEData() {
        return new FlowableTransformer<JUHENewsResponse<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<JUHENewsResponse<T>> upstream) {
                return upstream.flatMap(tjuheNewsResponse -> {
                    if (tjuheNewsResponse.getError_code() == 0) {
                        return tjuheNewsResponse.getResult();
                    } else {
                        //occur exception
                        return Flowable.error(new ApiException(tjuheNewsResponse.getError_code(),tjuheNewsResponse.getReason()));
                    }
                });
            }
        };
    }

}

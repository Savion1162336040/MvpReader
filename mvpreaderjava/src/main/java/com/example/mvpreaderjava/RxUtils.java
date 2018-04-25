package com.example.mvpreaderjava;

import com.example.mvpreaderjava.modle.bean.JUHENewsResponse;
import com.example.mvpreaderjava.modle.bean.JUHENewsResult;
import com.example.mvpreaderjava.modle.exception.ApiException;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
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

//    public static <T> FlowableTransformer<JUHENewsResponse<T>, T> parseJUHEData() {
//        return new FlowableTransformer<JUHENewsResponse<T>, T>() {
//            @Override
//            public Publisher<T> apply(Flowable<JUHENewsResponse<T>> upstream) {
//                return upstream.flatMap(tjuheNewsResponse -> {
//                    if (tjuheNewsResponse.getError_code() == 0) {
//                        return tjuheNewsResponse.getResult();
//                    } else {
//                        //occur exception
//                        return Flowable.error(new ApiException(tjuheNewsResponse.getError_code(),tjuheNewsResponse.getReason()));
//                    }
//                });
//            }
//        };
//    }

    /**
     * 统一返回结果处理
     *
     * @return
     */
//    public static <T> FlowableTransformer<JUHENewsResponse<T>, T> handleResult() {   //compose判断结果
//        return new FlowableTransformer<JUHENewsResponse<T>, T>() {
//            @Override
//            public Flowable<T> apply(Flowable<JUHENewsResponse<T>> httpResponseFlowable) {
//                return httpResponseFlowable.flatMap(new Function<JUHENewsResponse<T>, Flowable<T>>() {
//                    @Override
//                    public Flowable<T> apply(JUHENewsResponse<T> tGankHttpResponse) {
//                        if(tGankHttpResponse.success()) {
//                            return tGankHttpResponse;
//                        } else {
//                            return Flowable.error(new ApiException("服务器返回error"));
//                        }
//                    }
//                });
//            }
//        };
//    }

    /**
     * 统一处理juhe数据
     *
     * @return
     */
    public static <R> FlowableTransformer<JUHENewsResponse<R>, R> handlerResult() {
        return upstream -> upstream.flatMap(rjuheNewsResponse -> {
            if (rjuheNewsResponse.success())
                return createFlowable(rjuheNewsResponse.getResult());
            else
                return Flowable.error(new ApiException("get juhe news result error"));
        });
    }

    /**
     * 统一处理juhe数据
     *
     * @param <D>
     * @return
     */
    public static <D> FlowableTransformer<JUHENewsResult<D>, D> handlerData() {
        return upstream -> upstream.flatMap(djuheNewsResult -> {
            if (djuheNewsResult.success())
                if (djuheNewsResult.getData() == null)
                    return Flowable.error(new ApiException("get juhe news data null"));
                else
                    return createFlowable(djuheNewsResult.getData());
            else
                return Flowable.error(new ApiException("get juhe news data error"));
        });
    }

    /**
     * 构造flowable<T>
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createFlowable(final T t) {
        return Flowable.create(emitter -> {
            try {
                emitter.onNext(t);
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        }, BackpressureStrategy.BUFFER);
    }
}

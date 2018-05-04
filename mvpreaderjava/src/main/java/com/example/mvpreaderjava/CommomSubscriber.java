package com.example.mvpreaderjava;

/**
 * Created by sw116 on 2018/4/25.
 */

import android.text.TextUtils;

import com.example.mvpreaderjava.modle.exception.ApiException;
import com.example.mvpreaderjava.modle.exception.DataEmptyException;
import com.example.mvpreaderjava.mvp.BaseView;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * 通用scriber处理
 *
 * @param <T>
 */
public abstract class CommomSubscriber<T> extends ResourceSubscriber<T> {

    private BaseView view = null;
    //是否通知视图遮罩
    private boolean isStateAsyn = false;

    public CommomSubscriber(BaseView view) {
        this(view, false);
    }

    public CommomSubscriber(BaseView view, boolean isStateAsyn) {
        this.view = view;
        this.isStateAsyn = isStateAsyn;
    }

    @Override
    public void onError(Throwable t) {
        if (t instanceof HttpException) {
            view.showToast(TextUtils.isEmpty(t.getMessage()) ? "数据加载失败" : t.getMessage());
        } else if (t instanceof ApiException) {
            view.showToast(t.getMessage());
        } else if (t instanceof DataEmptyException) {
            view.showToast(t.getMessage());
            if (isStateAsyn)
                view.empty();
            return;
        } else {
            view.showToast("未知错误");
        }
        if (isStateAsyn) {
            view.error();
        }
    }

    @Override
    public void onComplete() {
        view.complete();
    }

}
package com.example.mvpreaderjava.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by sw116 on 2018/4/19.
 */

public class RxPresenter<V extends BaseView> implements BasePresenter<V> {

    V view;
    private CompositeDisposable compositeDisposable;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void dettachView() {
        this.view = null;
        clear();
    }

    @Override
    public boolean isAttached() {
        return view == null ? false : true;
    }

    /**
     * 新增订阅管理
     * @param disposable
     */
    protected void add(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    /**
     * 清除所有订阅
     */
    protected void clear() {
        if (compositeDisposable != null)
            compositeDisposable.clear();
    }
}

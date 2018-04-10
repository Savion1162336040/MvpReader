package com.savion.mvpreader.contract;

import com.sw.mvp.presenter.BasePresenter;
import com.sw.mvp.view.IBaseView;

import org.jetbrains.annotations.NotNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by savion on 2018/4/9.
 * 控制订阅的生命周期
 */
public class RxPresenter<V extends IBaseView> implements BasePresenter<V> {

    private V view;
    private CompositeDisposable compositeDisposable;

    protected void add(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    protected void pop() {
        // TODO: 2018/4/9 取消单个订阅
    }

    /**
     * 清除所有订阅
     */
    protected void clear() {
        if (compositeDisposable != null)
            compositeDisposable.clear();
    }

    /**
     * 取消关联
     */
    @Override
    public void dettachView() {
        view = null;
        clear();
    }

    /**
     * 关联view
     *
     * @param iview
     */
    @Override
    public void attachView(@NotNull V iview) {
        this.view = iview;
    }

    /**
     * 当前view是否还在关联
     *
     * @return
     */
    @Override
    public boolean isViewAttach() {
        return view == null ? false : true;
    }

    public V getView() {
        return view;
    }
}

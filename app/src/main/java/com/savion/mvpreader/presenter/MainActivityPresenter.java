package com.savion.mvpreader.presenter;

import com.savion.mvpreader.R;
import com.savion.mvpreader.model.bean.Tab;
import com.savion.mvpreader.common.RxUtils;
import com.savion.mvpreader.contract.MainActivityContract;
import com.savion.mvpreader.contract.RxPresenter;
import com.savion.mvpreader.model.parse.TabsParse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by savion on 2018/4/9.
 */

public class MainActivityPresenter extends RxPresenter<MainActivityContract.View> implements MainActivityContract.Presenter<MainActivityContract.View> {
    @Inject
    public MainActivityPresenter() {

    }
    @Override
    public void getTabs() {
        add(Observable.create(emitter -> {
            if (isViewAttach()) {
                String[] tabs = getView().getIContext().getResources().getStringArray(R.array.main_tab);
                if (tabs == null || tabs.length <= 0)
                    emitter.onError(new IllegalStateException("no tabs data to show"));
                else
                    emitter.onNext(new TabsParse(tabs).parse());
            } else
                emitter.onComplete();
        }).doOnNext(o -> getView().loadTabs((List<Tab>) o)).doOnError(throwable -> {
            getView().showError(throwable.getMessage());
        }).compose(RxUtils.commonObserableScheduler()).subscribe());
    }
}

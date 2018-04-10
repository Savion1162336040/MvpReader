package com.savion.mvpreader.contract;

import com.savion.mvpreader.model.bean.Tab;
import com.sw.mvp.presenter.BasePresenter;
import com.sw.mvp.view.IBaseView;

import java.util.List;

/**
 * Created by savion on 2018/4/9.
 */
public class MainActivityContract {
    public interface Presenter<V extends IBaseView> extends BasePresenter<V> {

        void getTabs();

    }

    public interface View extends IBaseView {
        void openDrawer();

        void transforFragment(String fragment);

        void loadTabs(List<Tab> tabs);
    }
}

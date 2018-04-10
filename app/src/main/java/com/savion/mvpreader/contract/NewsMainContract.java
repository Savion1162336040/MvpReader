package com.savion.mvpreader.contract;

import com.savion.mvpreader.bean.Tab;
import com.sw.mvp.presenter.BasePresenter;
import com.sw.mvp.view.IBaseView;

import java.util.List;

/**
 * Created by savion on 2018/4/9.
 */

public class NewsMainContract {

    public interface Presenter<V extends IBaseView> extends BasePresenter<V> {
        void getTabs();
    }

    public interface View extends IBaseView {
        void addTab(Tab tab);

        void changeTabs(String tag);

        void loadTabs(List<Tab> tab);

        void loadTabTops(List<String> title);

        void addTabTop(String title);
    }
}

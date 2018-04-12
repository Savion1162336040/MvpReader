package com.savion.mvpreader.contract

import com.savion.mvpreader.model.bean.News
import com.savion.mvpreader.model.bean.Result
import com.savion.mvpreader.model.response.JUHENewsResponse
import com.sw.mvp.presenter.BasePresenter
import com.sw.mvp.view.IBaseView

/**
 * Created by savion on 2018/4/9.
 */

class NewsMessageContract {

    interface Presenter<V : IBaseView> : BasePresenter<V> {
        fun getNewsMessage(key: String)

        fun cancelCall()

        fun onSuccess(result: Result<List<News>>)

        fun onFailed(exception: String)
    }

    interface View : IBaseView {
        //初始化数据
        fun initPresenteData()

        //刷新列表数据
        fun notifyData(news: List<JUHENewsResponse.JUHENewsResponseData>)

        //开始刷新动画
        fun refreshStart()

        //结束刷新动画
        fun refreshCompelete()
    }
}

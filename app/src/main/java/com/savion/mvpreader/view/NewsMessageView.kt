package com.savion.mvpreader.view

import com.savion.mvpreader.bean.News
import com.sw.mvp.view.IBaseView

/**
 * Created by Administrator on 2018-01-02.
 */
interface NewsMessageView :IBaseView {
    //初始化数据
    fun initPresenteData()
    //刷新列表数据
    fun notifyData(news:List<News>)
    //开始刷新动画
    fun refreshStart()
    //结束刷新动画
    fun refreshCompelete()

}
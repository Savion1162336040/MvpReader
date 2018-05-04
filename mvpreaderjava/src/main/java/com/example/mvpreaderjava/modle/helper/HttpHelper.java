package com.example.mvpreaderjava.modle.helper;

import com.example.mvpreaderjava.modle.api.WanAndroidApi;
import com.example.mvpreaderjava.modle.bean.JUHE.JUHENewsData;
import com.example.mvpreaderjava.modle.bean.JUHE.JUHENewsResponse;
import com.example.mvpreaderjava.modle.bean.JUHE.JUHENewsResult;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sw116 on 2018/4/19.
 */
public interface HttpHelper extends WanAndroidApi{
    /**
     * 获取聚合新闻列表
     * @param type
     * @return
     */
    Flowable<JUHENewsResponse<JUHENewsResult<List<JUHENewsData>>>> getJuheNews(String type);

}

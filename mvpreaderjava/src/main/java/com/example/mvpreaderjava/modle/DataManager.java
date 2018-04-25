package com.example.mvpreaderjava.modle;

import com.example.mvpreaderjava.modle.bean.JUHENewsData;
import com.example.mvpreaderjava.modle.bean.JUHENewsResponse;
import com.example.mvpreaderjava.modle.bean.JUHENewsResult;
import com.example.mvpreaderjava.modle.helper.HttpHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by sw116 on 2018/4/24.
 */

public class DataManager implements HttpHelper {
    private HttpHelper httpHelper;

    public DataManager(HttpHelper helper) {
        httpHelper = helper;
    }

    @Override
    public Flowable<JUHENewsResponse<JUHENewsResult<List<JUHENewsData>>>> getJuheNews(String type) {
        return httpHelper.getJuheNews(type);
    }
}

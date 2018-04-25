package com.example.mvpreaderjava.modle.helper;

import com.example.mvpreaderjava.modle.api.JUHEService;
import com.example.mvpreaderjava.modle.bean.JUHENewsData;
import com.example.mvpreaderjava.modle.bean.JUHENewsResponse;
import com.example.mvpreaderjava.modle.bean.JUHENewsResult;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by sw116 on 2018/4/24.
 */

public class HttpManager implements HttpHelper {

    private JUHEService service;

    @Inject
    public HttpManager(JUHEService service) {
        this.service = service;
    }

    @Override
    public Flowable<JUHENewsResponse<JUHENewsResult<List<JUHENewsData>>>> getJuheNews(String type) {
        return service.getJuheNews(type, JUHEService.KEY);
    }
}

package com.savion.mvpreader.model;

import com.savion.mvpreader.bean.News;
import com.sw.mvp.biz.resultFormat.ParseTemp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2018-01-02.
 */

public class NewsCallback<E> implements Callback {

    private ParseTemp<E> parseTemp;

    public NewsCallback(ParseTemp<E> parseTemp) {
        if (parseTemp==null)
            throw  new NullPointerException("NewsCallback need a Parser");
        this.parseTemp = parseTemp;
    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {

    }
}

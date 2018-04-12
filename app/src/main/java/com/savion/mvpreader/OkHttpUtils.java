package com.savion.mvpreader;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.savion.mvpreader.model.parse.NewsParse;
import com.savion.mvpreader.presenter.NewsMessagePresenter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018-01-02.
 */

public class OkHttpUtils {
    public static final String API_NEWS_MESSAGE = "http://v.juhe.cn/toutiao/index?type=%s&key=%s";

    private static OkHttpUtils instance;
    private OkHttpClient client;
    private Map<String, Call> callMap;

    private Handler mainHandler;
    private OkHttpUtils() {
        client = new OkHttpClient.Builder().readTimeout(5000, TimeUnit.MILLISECONDS).connectTimeout(5000,TimeUnit.MILLISECONDS).writeTimeout(5000,TimeUnit.MILLISECONDS).build();
        callMap = new HashMap<>();
        mainHandler = new Handler(Looper.getMainLooper());
    }

    public static OkHttpUtils getInstance() {
        if (instance == null)
            instance = new OkHttpUtils();
        return instance;
    }

    public void getNewsMessage(String type, final NewsMessagePresenter presenter) {
        Log.w(Constant.TAG, String.format("getNewsMessage:%s", type));
        final Request request = new Request.Builder().url(String.format(API_NEWS_MESSAGE, type,Constant.JUHE_NEWS_APPKEY)).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                Log.w(Constant.TAG, String.format("getNewsMessage onFailure:%s,%s", e.getMessage(),e.getCause()));
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        presenter.onFailed("getNewsMessage failed with Exception:"+ (TextUtils.isEmpty(e.getMessage())?e.getMessage():"null"));
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //presenter.onSuccess(response.body().toString());
                String string = response.body().string().toString();
                Log.w(Constant.TAG, String.format("getNewsMessage onResponse:%s", string));
//                final Result<List<News>> result = new NewsParse(string).parse();
//                mainHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (result.getError_code() != 0) {
//                            presenter.onFailed(result.getError_message());
//                        } else {
//                            presenter.onSuccess(result);
//                        }
//                    }
//                });
            }
        });
        callMap.put(API_NEWS_MESSAGE, call);
    }

    public boolean cancelCall(String key) {
        if (callMap.get(key) != null && !callMap.get(key).isCanceled() && callMap.get(key).isExecuted()) {
            callMap.get(key).cancel();
            callMap.remove(key);
            return true;
        }
        return false;
    }


}

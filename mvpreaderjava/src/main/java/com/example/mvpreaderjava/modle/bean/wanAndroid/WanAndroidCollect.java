package com.example.mvpreaderjava.modle.bean.wanAndroid;

import com.example.mvpreaderjava.modle.helper.ResponseHelper;

/**
 * Created by sw116 on 2018/5/3.
 */

public class WanAndroidCollect extends WanAndroidBasePost implements ResponseHelper {
    /**
     * userId : 5296
     */

    private int userId;

    @Override
    public boolean success() {
        return false;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

package com.example.mvpreaderjava.modle.bean.wanAndroid;

import com.example.mvpreaderjava.modle.helper.ResponseHelper;

/**
 * Created by sw116 on 2018/5/3.
 * WanAndroid api bean
 * http://www.wanandroid.com/
 */
public class WanAndroidResponse<D> implements ResponseHelper {
    /**
     * data : ...
     * errorCode : 0
     * errorMsg :
     */
    private D data;
    private int errorCode;
    private String errorMsg;

    @Override
    public boolean success() {
        return errorCode >= 0 ? true : false;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "WanAndroidResponse{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}

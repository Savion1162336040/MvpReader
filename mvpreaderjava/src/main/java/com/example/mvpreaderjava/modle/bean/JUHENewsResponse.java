package com.example.mvpreaderjava.modle.bean;

import android.text.TextUtils;

import com.example.mvpreaderjava.modle.helper.ResponseHelper;

import java.util.List;

/**
 * Created by sw116 on 2018/4/19.
 */

public class JUHENewsResponse<R> implements ResponseHelper {

    private int error_code;
    private String reason;
    private R result;

    @Override
    public String toString() {
        return "JUHENewsResponse{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result.toString() +
                '}';
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public R getResult() {
        return result;
    }

    public void setResult(R result) {
        this.result = result;
    }

    @Override
    public boolean success() {
        return error_code == 0;
    }
}

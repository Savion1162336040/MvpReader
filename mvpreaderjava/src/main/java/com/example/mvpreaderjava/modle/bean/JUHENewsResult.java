package com.example.mvpreaderjava.modle.bean;

import com.example.mvpreaderjava.modle.helper.ResponseHelper;

/**
 * Created by sw116 on 2018/4/25.
 */

public class JUHENewsResult<D> implements ResponseHelper {
    private int stat;
    private D data;

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    @Override
    public boolean success() {
        return stat == 1;
    }

    @Override
    public String toString() {
        return "Result{" +
                "stat=" + stat +
                ", data=" + data +
                '}';
    }
}
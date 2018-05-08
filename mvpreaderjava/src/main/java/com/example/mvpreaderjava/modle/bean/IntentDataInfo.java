package com.example.mvpreaderjava.modle.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-09-12.
 */
public class IntentDataInfo implements Serializable {
    private String extraString;
    private boolean extraBoolean;
    private int extraInt;
    private double extraDouble;
    private float extraFloat;
    public IntentDataInfo(){}
    public IntentDataInfo(String extraString){
        this.extraString = extraString;
    }

    public String getExtraString() {
        return extraString;
    }

    public void setExtraString(String extraString) {
        this.extraString = extraString;
    }

    public boolean isExtraBoolean() {
        return extraBoolean;
    }

    public void setExtraBoolean(boolean extraBoolean) {
        this.extraBoolean = extraBoolean;
    }

    public int getExtraInt() {
        return extraInt;
    }

    public void setExtraInt(int extraInt) {
        this.extraInt = extraInt;
    }

    public double getExtraDouble() {
        return extraDouble;
    }

    public void setExtraDouble(double extraDouble) {
        this.extraDouble = extraDouble;
    }

    public float getExtraFloat() {
        return extraFloat;
    }

    public void setExtraFloat(float extraFloat) {
        this.extraFloat = extraFloat;
    }
}

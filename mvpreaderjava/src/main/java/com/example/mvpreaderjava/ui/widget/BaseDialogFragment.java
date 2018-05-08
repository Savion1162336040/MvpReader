package com.example.mvpreaderjava.ui.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.example.mvpreaderjava.Constant;
import com.example.mvpreaderjava.modle.bean.IntentDataInfo;
import com.example.mvpreaderjava.ui.widget.imp.OnDialogCallBack;

/**
 * Created by Administrator on 2017-09-18.
 */
public abstract class BaseDialogFragment extends DialogFragment {
    protected OnDialogCallBack mCallBack;
    private IntentDataInfo mdata;

    public IntentDataInfo getMdata() {
        return mdata;
    }


    public void setMdata(IntentDataInfo mdata) {
        this.mdata = mdata;
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        try {
            mdata = (IntentDataInfo) args.getSerializable(Constant.INTENT_KEY);
        }catch (Exception e){
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof OnDialogCallBack)) {
            throw new ClassCastException("dialog fragment所在activity必须实现OnDialogCallBack接口");
        } else {
            mCallBack = (OnDialogCallBack) activity;
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        mCallBack.onDismiss(this);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        mCallBack.onCancel(this);
    }
}

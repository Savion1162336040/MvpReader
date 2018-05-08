package com.example.mvpreaderjava.ui.widget.imp;

import android.support.v4.app.DialogFragment;

/**
 * Created by Administrator on 2017-09-18.
 */
public interface OnDialogCallBack {
    void onDismiss(DialogFragment v);
    void onCancel(DialogFragment v);
    void onError(DialogFragment v, String str);
    void onSure(DialogFragment v, int white);
}

package com.example.mvpreaderjava.ui.base;

import android.content.Intent;

import java.io.Serializable;

public class ExtraDelegateActivity<D extends Serializable, TARGET extends ExtraDelegateBehavior<D>> extends ExtraDelegate<TARGET> {

    protected D _data;

    public ExtraDelegateActivity(TARGET extraDelegateBehavior) {
        super(extraDelegateBehavior);
    }

    public void onNewIntent(Intent intent) {
        target.onNewIntent(_data);
    }

    public void onSaveInstance() {

    }

    public void onCreate(Intent intent) {
        target.onBundle(_data);
    }
}

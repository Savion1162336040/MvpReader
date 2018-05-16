package com.example.mvpreaderjava.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.io.Serializable;

public abstract class IntentActivity<I extends Serializable> extends SimpleActivity implements ExtraDelegateBehavior<I>{

    protected I _intent;
    private String key = "_intent";

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            Serializable serializable = savedInstanceState.getSerializable(key);
            if (serializable != null) {
                _intent = (I) serializable;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}

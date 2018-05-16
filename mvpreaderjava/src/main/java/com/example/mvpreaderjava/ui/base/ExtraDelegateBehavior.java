package com.example.mvpreaderjava.ui.base;

public interface ExtraDelegateBehavior<T> {

    void onNewIntent(T newIntent);

    void onBundle(T bundle);

}

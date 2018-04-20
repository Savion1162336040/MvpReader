package com.example.mvpreaderjava.ui.bind;

import android.support.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;

/**
 * Created by savion on 2018/4/10.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
@ListenerClass(setter = "setOnRefreshListener",
        type = "android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener",
        targetType = "android.support.v4.widget.SwipeRefreshLayout",
        method = @ListenerMethod(name = "onRefresh")
)
public @interface OnSwipeRefresh {
    @IdRes int[] value();
}

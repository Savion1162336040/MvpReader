package com.savion.mvpreader.ui.bind;

import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;

/**
 * Created by savion on 2018/4/9.
 * 实现NavigationView的OnNavigationItemSelected事件注入
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
@ListenerClass(targetType = "android.support.design.widget.NavigationView",
        setter = "setNavigationItemSelectedListener",
        type = "android.support.design.widget.NavigationView.OnNavigationItemSelectedListener",
        method = @ListenerMethod(
                name = "onNavigationItemSelected",
                returnType = "boolean",
                defaultReturn = "false",
                parameters = {"android.view.MenuItem"}
        )
)
public @interface OnNavigationSelected {
    //ids
    @IdRes int[] value();
}

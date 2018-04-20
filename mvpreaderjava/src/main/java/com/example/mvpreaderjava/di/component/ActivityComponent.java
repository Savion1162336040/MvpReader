package com.example.mvpreaderjava.di.component;

import com.example.mvpreaderjava.ui.activity.MainActivity;
import com.example.mvpreaderjava.di.module.ActivityModule;
import com.example.mvpreaderjava.di.scope.PerActivity;

import dagger.Component;

/**
 * Created by sw116 on 2018/4/19.
 */
@PerActivity
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}

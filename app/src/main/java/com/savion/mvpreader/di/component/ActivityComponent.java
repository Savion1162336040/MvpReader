package com.savion.mvpreader.di.component;

import android.app.Activity;

import com.savion.mvpreader.di.scope.PerActivity;
import com.savion.mvpreader.ui.activity.MainActivity;
import com.savion.mvpreader.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by savion on 2018/4/9.
 */
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
@PerActivity
public interface ActivityComponent {

    Activity getActivity();

    void inject(MainActivity activity);

}

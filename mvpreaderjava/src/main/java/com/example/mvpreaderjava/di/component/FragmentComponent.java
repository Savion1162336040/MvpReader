package com.example.mvpreaderjava.di.component;

import com.example.mvpreaderjava.di.module.FragmentModule;
import com.example.mvpreaderjava.di.scope.PerFragment;

import dagger.Component;

/**
 * Created by sw116 on 2018/4/19.
 */
@PerFragment
@Component(modules = FragmentModule.class,dependencies = AppComponent.class)
public interface FragmentComponent {



}

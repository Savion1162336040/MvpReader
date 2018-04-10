package com.savion.mvpreader.ui

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by savion on 2018/4/10.
 */

class Test {


    private fun a() {


        Flowable.create<Any>({ emitter -> }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()

    }
}

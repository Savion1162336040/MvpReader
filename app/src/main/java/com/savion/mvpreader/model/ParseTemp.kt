package com.sw.mvp.biz.resultFormat

import org.json.JSONObject

/**
 * Created by Administrator on 2017-12-22.
 */
abstract class ParseTemp<E> {

    abstract fun parse(): E
    /**
     * hook fun
     * maybe useful
     */
    abstract fun hook(): Boolean
}
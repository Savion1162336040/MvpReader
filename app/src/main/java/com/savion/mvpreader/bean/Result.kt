package com.savion.mvpreader.bean

/**
 * Created by Administrator on 2018-01-02.
 */
class Result<T> {
    var content: T? = null
    var error_code = 0
    var error_message = ""
}
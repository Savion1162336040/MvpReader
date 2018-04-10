package com.savion.mvpreader.model.exception

import java.lang.Exception


/**
 * Created by savion on 2018/4/10.
 */
class ApiException : Exception {

    private var code: Int = 0

    constructor() : super("unknown api exception occur")

    constructor(msg: String) : super(msg)

    constructor(code: Int, msg: String) : super(msg) {
        this.code = code
    }


}
package com.savion.mvpreader.bean

import java.io.Serializable

/**
 * Created by Administrator on 2017-12-28.
 */
class Blog : Serializable {
    var id = 0
    var title = ""
    var content = ""
    var url = ""
    var icon = ""
    override fun toString(): String {
        return super.toString()
    }
}
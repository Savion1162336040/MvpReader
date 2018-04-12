package com.savion.mvpreader.model.bean

import java.io.Serializable

/**
 * Created by Administrator on 2017-12-28.
 */
class News : Serializable {
    var id = ""
    var title = ""
    var content = ""
    var url = ""
    var icon = ""
    var date = ""
    var from = ""
    override fun toString(): String {
        return "News(id=$id, title='$title', content='$content', url='$url', icon='$icon', date='$date', from='$from')"
    }

}
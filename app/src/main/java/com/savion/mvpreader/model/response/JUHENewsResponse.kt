package com.savion.mvpreader.model.response

/**
 * Created by savion on 2018/4/10.
 */
class JUHENewsResponse<T>() {

    var error_code: Int? = null
    var reason: String? = null
    var result: T? = null

    class JUHENewsResponseResule<T>() {
        var stat: Int? = null
        var data: T? = null
    }

    class JUHENewsResponseData() {
        var uniquekey: String? = null
        var title: String? = null
        var date: String? = null
        var category: String? = null
        var author_name: String? = null
        var url: String? = null
        var thumbnail_pic_s: String? = null
        var thumbnail_pic_s02: String? = null
        var thumbnail_pic_s03: String? = null
        override fun toString(): String {
            return "JUHENewsResponseData(uniquekey=$uniquekey, title=$title, date=$date, category=$category, author_name=$author_name, url=$url, thumbnail_pic_s=$thumbnail_pic_s, thumbnail_pic_s02=$thumbnail_pic_s02, thumbnail_pic_s03=$thumbnail_pic_s03)"
        }
    }

}
package com.savion.mvpreader.model.parse

import com.google.gson.Gson
import com.savion.mvpreader.model.bean.News
import com.savion.mvpreader.model.bean.NewsMessageSource
import com.savion.mvpreader.model.bean.Result

/**
 * Created by Administrator on 2018-01-02.
 */
class NewsParse(val jsonObject: String) : ParseTemp<Result<List<News>>>() {
    override fun hook(): Boolean {
        return true
    }

    override fun parse(): Result<List<News>> {
        val news = Gson().fromJson<NewsMessageSource>(jsonObject, NewsMessageSource::class.java)
        var result: Result<List<News>> = Result()
        result.error_code = news.error_code
        result.error_message = news.reason
        if (news.result!=null&&news.result.data!=null&&news.result.data.size>0) {
            var newsList:ArrayList<News> = ArrayList<News>()
            var en: News
            for (news in news.result.data){
                en = News()
                en.id = news.uniquekey
                en.date = news.date
                en.from = news.author_name
                en.icon = news.thumbnail_pic_s
                en.title = news.title
                en.url = news.url
                en.content=news.url
                newsList.add(en)
            }
            result.content = newsList
        }
        return result
    }
}
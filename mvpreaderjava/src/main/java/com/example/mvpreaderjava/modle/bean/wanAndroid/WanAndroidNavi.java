package com.example.mvpreaderjava.modle.bean.wanAndroid;

import java.util.List;

/**
 * Created by sw116 on 2018/5/3.
 * 3.1 导航数据
 * http://www.wanandroid.com/navi/json
 */
public class WanAndroidNavi {
    /**
     * articles :
     * cid : 272
     * name : 常用网站
     */
    private List<WanAndroidPost> articles;
    private int cid;
    private String name;

    public List<WanAndroidPost> getArticles() {
        return articles;
    }

    public void setArticles(List<WanAndroidPost> articles) {
        this.articles = articles;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

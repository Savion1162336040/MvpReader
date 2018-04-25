package com.example.mvpreaderjava.modle.bean;

import java.io.Serializable;

/**
 * Created by sw116 on 2018/4/24.
 */

public class Tabs implements Serializable{

    /**
     * title : 全部
     * type : all
     */

    private String title;
    private String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tabs{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

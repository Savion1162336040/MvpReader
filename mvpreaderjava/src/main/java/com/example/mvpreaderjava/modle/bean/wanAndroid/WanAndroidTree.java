package com.example.mvpreaderjava.modle.bean.wanAndroid;

import java.util.List;

/**
 * Created by sw116 on 2018/5/3.
 * 体系数据
 * 主要标识的网站内容的体系结构，二级目录。
 * http://www.wanandroid.com/tree/json
 */
public class WanAndroidTree {
    /**
     * children :
     * courseId : 13
     * id : 150
     * name : 开发环境
     * order : 1
     * parentChapterId : 0
     * visible : 1
     */

    private List<WanAndroidTree> children;
    private int courseId;
    private int id;
    private String name;
    private int order;
    private int parentChapterId;
    private int visible;

    public List<WanAndroidTree> getChildren() {
        return children;
    }

    public void setChildren(List<WanAndroidTree> children) {
        this.children = children;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}

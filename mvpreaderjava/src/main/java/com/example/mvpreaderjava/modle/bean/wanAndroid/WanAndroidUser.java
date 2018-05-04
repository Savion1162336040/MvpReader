package com.example.mvpreaderjava.modle.bean.wanAndroid;

import java.util.List;

/**
 * Created by sw116 on 2018/5/3.
 * 6.1 收藏文章列表
 * http://www.wanandroid.com/lg/collect/list/0/json
 */
public class WanAndroidUser {
    /**
     * collectIds : []
     * email :
     * icon :
     * id : 5296
     * password : sbvke820820sw
     * type : 0
     * username : savion_sw
     */

    private String email;
    private String icon;
    private int id;
    private String password;
    private int type;
    private String username;
    private List<?> collectIds;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<?> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<?> collectIds) {
        this.collectIds = collectIds;
    }
}

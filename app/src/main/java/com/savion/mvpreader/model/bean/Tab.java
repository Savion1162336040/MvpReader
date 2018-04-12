package com.savion.mvpreader.model.bean;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-12-29.
 */

public class Tab implements Serializable {

    /**
     * tag : news
     * id : 1
     * isRemote : false
     * parent : main
     * target :
     */

    private String tag;
    private String id;
    private boolean isRemote;
    private String parent;
    private String target;
    private String title;

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIsRemote() {
        return isRemote;
    }

    public void setIsRemote(boolean isRemote) {
        this.isRemote = isRemote;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean enable(){
        return TextUtils.isEmpty(getTitle())||TextUtils.isEmpty(getTag())?false:true;
    }
}

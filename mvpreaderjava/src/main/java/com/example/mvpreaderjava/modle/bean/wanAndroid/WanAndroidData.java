package com.example.mvpreaderjava.modle.bean.wanAndroid;

import java.util.List;

/**
 * Created by sw116 on 2018/5/3.
 */
public class WanAndroidData {
    /**
     * curPage : 2
     * offset : 20
     * over : false
     * pageCount : 63
     * size : 20
     * total : 1245
     */
    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<WanAndroidPost> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<WanAndroidPost> getDatas() {
        return datas;
    }

    public void setDatas(List<WanAndroidPost> datas) {
        this.datas = datas;
    }
}

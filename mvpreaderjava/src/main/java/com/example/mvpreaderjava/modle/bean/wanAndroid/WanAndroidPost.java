package com.example.mvpreaderjava.modle.bean.wanAndroid;

import com.example.mvpreaderjava.modle.helper.ResponseHelper;

import java.util.List;

/**
 * Created by sw116 on 2018/5/3.
 */

public class WanAndroidPost extends WanAndroidBasePost implements ResponseHelper {
    /**
     * apkLink :
     * collect : false
     * fresh : false
     * projectLink :
     * superChapterId : 249
     * superChapterName : 干货资源
     * tags : []
     * type : 0
     */

    private String apkLink;
    private boolean collect;
    private boolean fresh;
    private String projectLink;
    private int superChapterId;
    private String superChapterName;
    private int type;
    private List<WanAndroidTag> tags;

    public String getApkLink() {
        return apkLink;
    }

    public void setApkLink(String apkLink) {
        this.apkLink = apkLink;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public int getSuperChapterId() {
        return superChapterId;
    }

    public void setSuperChapterId(int superChapterId) {
        this.superChapterId = superChapterId;
    }

    public String getSuperChapterName() {
        return superChapterName;
    }

    public void setSuperChapterName(String superChapterName) {
        this.superChapterName = superChapterName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<WanAndroidTag> getTags() {
        return tags;
    }

    public void setTags(List<WanAndroidTag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean success() {
        return false;
    }
    /**
     * apkLink :
     * author : 鸿洋
     * chapterId : 249
     * chapterName : 干货资源
     * collect : false
     * courseId : 13
     * desc :
     * envelopePic :
     * fresh : false
     * id : 2846
     * link : https://mp.weixin.qq.com/s/NzxdRU1r6bPGFn_gsUFCmw
     * niceDate : 2018-04-23
     * origin :
     * projectLink :
     * publishTime : 1524449010000
     * superChapterId : 249
     * superChapterName : 干货资源
     * tags : []
     * title : 推荐三个完整开源项目
     * type : 0
     * visible : 1
     * zan : 0
     */

//    private String apkLink;
//    private boolean collect;
//    private boolean fresh;
//    private String projectLink;
//    private int superChapterId;
//    private String superChapterName;
//    private int type;
//    private List<WanAndroidTag> tags;
//
//    @Override
//    public boolean success() {
//        return false;
//    }
//
//
//    public String getApkLink() {
//        return apkLink;
//    }
//
//    public void setApkLink(String apkLink) {
//        this.apkLink = apkLink;
//    }
//
//    public String getAuthor() {
//        return getAuthor();
//    }
//
//    public void setAuthor(String author) {
//        setAuthor(author);
//    }
//
//    public int getChapterId() {
//        return getChapterId();
//    }
//
//    public void setChapterId(int chapterId) {
//        setChapterId(chapterId);
//    }
//
//    public String getChapterName() {
//        return getChapterName();
//    }
//
//    public void setChapterName(String chapterName) {
//        setChapterName(chapterName);
//    }
//
//    public boolean isCollect() {
//        return collect;
//    }
//
//    public void setCollect(boolean collect) {
//        this.collect = collect;
//    }
//
//    public int getCourseId() {
//        return getCourseId();
//    }
//
//    public void setCourseId(int courseId) {
//        setCourseId(courseId);
//    }
//
//    public String getDesc() {
//        return getDesc();
//    }
//
//    public void setDesc(String desc) {
//        setDesc(desc);
//    }
//
//    public String getEnvelopePic() {
//        return getEnvelopePic();
//    }
//
//    public void setEnvelopePic(String envelopePic) {
//        setEnvelopePic(envelopePic);
//    }
//
//    public boolean isFresh() {
//        return fresh;
//    }
//
//    public void setFresh(boolean fresh) {
//        this.fresh = fresh;
//    }
//
//    public int getId() {
//        return getId();
//    }
//
//    public void setId(int id) {
//        setId(id);
//    }
//
//    public String getLink() {
//        return getLink();
//    }
//
//    public void setLink(String link) {
//        setLink(link);
//    }
//
//    public String getNiceDate() {
//        return getNiceDate();
//    }
//
//    public void setNiceDate(String niceDate) {
//        setNiceDate(niceDate);
//    }
//
//    public String getOrigin() {
//        return getOrigin();
//    }
//
//    public void setOrigin(String origin) {
//        setOrigin(origin);
//    }
//
//    public String getProjectLink() {
//        return projectLink;
//    }
//
//    public void setProjectLink(String projectLink) {
//        this.projectLink = projectLink;
//    }
//
//    public long getPublishTime() {
//        return getPublishTime();
//    }
//
//    public void setPublishTime(long publishTime) {
//        setPublishTime(publishTime);
//    }
//
//    public int getSuperChapterId() {
//        return superChapterId;
//    }
//
//    public void setSuperChapterId(int superChapterId) {
//        this.superChapterId = superChapterId;
//    }
//
//    public String getSuperChapterName() {
//        return superChapterName;
//    }
//
//    public void setSuperChapterName(String superChapterName) {
//        this.superChapterName = superChapterName;
//    }
//
//    public String getTitle() {
//        return getTitle();
//    }
//
//    public void setTitle(String title) {
//        setTitle(title);
//    }
//
//    public int getType() {
//        return type;
//    }
//
//    public void setType(int type) {
//        this.type = type;
//    }
//
//    public int getVisible() {
//        return getVisible();
//    }
//
//    public void setVisible(int visible) {
//        setVisible(visible);
//    }
//
//    public int getZan() {
//        return getZan();
//    }
//
//    public void setZan(int zan) {
//        setZan(
//                zan
//        );
//    }
//
//    public List<WanAndroidTag> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<WanAndroidTag> tags) {
//        this.tags = tags;
//    }

}

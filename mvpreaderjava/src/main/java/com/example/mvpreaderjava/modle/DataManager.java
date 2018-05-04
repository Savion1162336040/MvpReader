package com.example.mvpreaderjava.modle;

import com.example.mvpreaderjava.modle.bean.JUHE.JUHENewsData;
import com.example.mvpreaderjava.modle.bean.JUHE.JUHENewsResponse;
import com.example.mvpreaderjava.modle.bean.JUHE.JUHENewsResult;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidBanner;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidCollect;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidData;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidFriend;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidHotkey;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidNavi;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidResponse;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidTree;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidUser;
import com.example.mvpreaderjava.modle.helper.HttpHelper;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sw116 on 2018/4/24.
 */

public class DataManager implements HttpHelper {
    private HttpHelper httpHelper;

    public DataManager(HttpHelper helper) {
        httpHelper = helper;
    }

    @Override
    public Flowable<JUHENewsResponse<JUHENewsResult<List<JUHENewsData>>>> getJuheNews(String type) {
        return httpHelper.getJuheNews(type);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidData>> getMainPostList(int page) {
        return httpHelper.getMainPostList(page);
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidBanner>>> getBannerList() {
        return httpHelper.getBannerList();
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidFriend>>> getFriendList() {
        return null;
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidHotkey>>> getHotkeyList() {
        return httpHelper.getHotkeyList();
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidTree>>> getTreeList() {
        return httpHelper.getTreeList();
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidData>> getTreePostList(int page, int cid) {
        return httpHelper.getTreePostList(page, cid);
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidNavi>>> getNavi() {
        return httpHelper.getNavi();
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidTree>>> getProjectTree() {
        return httpHelper.getProjectTree();
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidData>> getProjectPostList(int page, int cid) {
        return httpHelper.getProjectPostList(page, cid);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidUser>> login(String name, String pwd) {
        return httpHelper.login(name, pwd);
    }

    @Override
    public Flowable<WanAndroidResponse<String>> registe(String username, String password, String repassword) {
        return httpHelper.registe(username, password, repassword);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidCollect>> getCollect(int page) {
        return httpHelper.getCollect(page);
    }

    @Override
    public Flowable<WanAndroidResponse<String>> addCollectInner(int id) {
        return httpHelper.addCollectInner(id);
    }

    @Override
    public Flowable<WanAndroidResponse<String>> addCollectOut(String title, String author, String link) {
        return httpHelper.addCollectOut(title, author, link);
    }

    @Override
    public Flowable<WanAndroidResponse<String>> unCollect(int id) {
        return httpHelper.unCollect(id);
    }

    @Override
    public Flowable<WanAndroidResponse<String>> getCollectSiteList() {
        return httpHelper.getCollectSiteList();
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidFriend>> addCollectSite(String name, String link) {
        return httpHelper.addCollectSite(name, link);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidFriend>> updateCollectSite(int id, String name, String link) {
        return httpHelper.updateCollectSite(id, name, link);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidFriend>> deleteCollectSite(int id) {
        return httpHelper.deleteCollectSite(id);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidData>> search(String key, int page) {
        return httpHelper.search(key, page);
    }
}

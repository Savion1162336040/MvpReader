package com.example.mvpreaderjava.modle.helper;

import com.example.mvpreaderjava.modle.api.JUHEService;
import com.example.mvpreaderjava.modle.api.WanAndroidApi;
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

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by sw116 on 2018/4/24.
 */

public class HttpManager implements HttpHelper {

    private JUHEService service;
    private WanAndroidApi wanAndroidApi;

    @Inject
    public HttpManager(JUHEService service, WanAndroidApi wanAndroidApi) {
        this.service = service;
        this.wanAndroidApi = wanAndroidApi;
    }

    @Override
    public Flowable<JUHENewsResponse<JUHENewsResult<List<JUHENewsData>>>> getJuheNews(String type) {
        return service.getJuheNews(type, JUHEService.KEY);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidData>> getMainPostList(int page) {
        return wanAndroidApi.getMainPostList(page);
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidBanner>>> getBannerList() {
        return wanAndroidApi.getBannerList();
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidFriend>>> getFriendList() {
        return wanAndroidApi.getFriendList();
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidHotkey>>> getHotkeyList() {
        return wanAndroidApi.getHotkeyList();
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidTree>>> getTreeList() {
        return wanAndroidApi.getTreeList();
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidData>> getTreePostList(int page, int cid) {
        return wanAndroidApi.getTreePostList(page, cid);
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidNavi>>> getNavi() {
        return wanAndroidApi.getNavi();
    }

    @Override
    public Flowable<WanAndroidResponse<List<WanAndroidTree>>> getProjectTree() {
        return wanAndroidApi.getProjectTree();
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidData>> getProjectPostList(int page, int cid) {
        return wanAndroidApi.getProjectPostList(page, cid);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidUser>> login(String name, String pwd) {
        return wanAndroidApi.login(name, pwd);
    }

    @Override
    public Flowable<WanAndroidResponse<String>> registe(String username, String password, String repassword) {
        return wanAndroidApi.registe(username, password, repassword);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidCollect>> getCollect(int page) {
        return wanAndroidApi.getCollect(page);
    }

    @Override
    public Flowable<WanAndroidResponse<String>> addCollectInner(int id) {
        return wanAndroidApi.addCollectInner(id);
    }

    @Override
    public Flowable<WanAndroidResponse<String>> addCollectOut(String title, String author, String link) {
        return wanAndroidApi.addCollectOut(title, author, link);
    }

    @Override
    public Flowable<WanAndroidResponse<String>> unCollect(int id) {
        return wanAndroidApi.unCollect(id);
    }

    @Override
    public Flowable<WanAndroidResponse<String>> getCollectSiteList() {
        return wanAndroidApi.getCollectSiteList();
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidFriend>> addCollectSite(String name, String link) {
        return wanAndroidApi.addCollectSite(name, link);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidFriend>> updateCollectSite(int id, String name, String link) {
        return wanAndroidApi.updateCollectSite(id, name, link);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidFriend>> deleteCollectSite(int id) {
        return wanAndroidApi.deleteCollectSite(id);
    }

    @Override
    public Flowable<WanAndroidResponse<WanAndroidData>> search(String key, int page) {
        return wanAndroidApi.search(key, page);
    }
}

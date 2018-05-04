package com.example.mvpreaderjava.modle.api;

import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidCollect;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidNavi;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidResponse;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidBanner;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidData;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidFriend;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidHotkey;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidTree;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidUser;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sw116 on 2018/5/3.
 */

public interface WanAndroidApi {

    public static final String BASE_API = "http://www.wanandroid.com/";

    /**
     * 1.1 首页文章列表
     * 方法：GET
     * 参数：页码，拼接在连接中，从0开始。
     * 其中有两个易混淆的字段:
     * "superChapterId": 153,
     * "superChapterName": "framework", // 一级分类的名称
     * superChapterId其实不是一级分类id，因为要拼接跳转url，内容实际都挂在二级分类下，所以该id实际上是一级分类的第一个子类目的id，拼接后故可正常跳转。
     *
     * @param page
     * @return
     */
    @GET("article/list/{page}/json")
    public Flowable<WanAndroidResponse<WanAndroidData>> getMainPostList(@Path("page") int page);

    /**
     * 1.2 首页banner
     * @return
     */
    @GET("banner/json")
    public Flowable<WanAndroidResponse<List<WanAndroidBanner>>> getBannerList();

    /**
     * 1.3 常用网站
     * @return
     */
    @GET("friend/json")
    public Flowable<WanAndroidResponse<List<WanAndroidFriend>>> getFriendList();

    /**
     * 1.4 搜索热词
     * 即目前搜索最多的关键词。
     * @return
     */
    @GET("hotkey/json")
    public Flowable<WanAndroidResponse<List<WanAndroidHotkey>>> getHotkeyList();

    /**
     * 2.1 体系数据
     * @return
     */
    @GET("tree/json")
    public Flowable<WanAndroidResponse<List<WanAndroidTree>>> getTreeList();

    /**
     * 2.2 知识体系下的文章
     * 参数：
     * cid 分类的id，上述二级目录的id
     * 页码：拼接在链接上，从0开始。
     * @param page
     * @param cid
     * @return
     */
    @GET("article/list/{page}/json")
    public Flowable<WanAndroidResponse<WanAndroidData>> getTreePostList(@Path("page") int page,@Query("cid") int cid);
    /**
     * 3.1 导航数据
     */
    @GET("navi/json")
    public Flowable<WanAndroidResponse<List<WanAndroidNavi>>> getNavi();


    /**
     * 4.1 项目分类
     */
    @GET("project/tree/json")
    public Flowable<WanAndroidResponse<List<WanAndroidTree>>> getProjectTree();

    /**
     * 4.2 项目列表数据
     * @param page
     * @param cid
     * @return
     */
    @GET("project/list/{page}/json")
    public Flowable<WanAndroidResponse<WanAndroidData>> getProjectPostList(@Path("page")int page,@Query("cid") int cid);

    /**
     * 5.1 登录
     * @param name
     * @param pwd
     * @return
     */
    @POST("user/login")
    public Flowable<WanAndroidResponse<WanAndroidUser>> login(@Field("username") String name, @Field("password") String pwd);

    /**
     * 5.2 注册
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @POST("user/register")
    public Flowable<WanAndroidResponse<String>> registe(@Field("username")String username,@Field("password") String password,@Field("repassword")String repassword);

    /**
     * 6.1 收藏文章列表
     * @param page
     * @return
     */
    @GET("lg/collect/list/{page}/json")
    public Flowable<WanAndroidResponse<WanAndroidCollect>> getCollect(@Path("page") int page);

    /**
     * 6.2 收藏站内文章
     * @param id
     * @return
     */
    @POST("lg/collect/{id}/json")
    public Flowable<WanAndroidResponse<String>> addCollectInner(@Path("id") int id);
    /**
     * 6.3 收藏站外文章
     * @param title
     * @param author
     * @param link
     * @return
     */
    @POST("lg/collect/add/json")
    public Flowable<WanAndroidResponse<String>> addCollectOut(@Field("title") String title,@Field("author")String author,@Field("link")String link);

    /**
     * 6.4 取消收藏
     * @param id
     * @return
     */
    @POST("lg/uncollect_originId/{id}/json")
    public Flowable<WanAndroidResponse<String>> unCollect(@Path("id") int id);

    /**
     * 6.5 收藏网站列表
     * @return
     */
    @GET("lg/collect/usertools/json")
    public Flowable<WanAndroidResponse<String>> getCollectSiteList();

    /**
     * 6.6 收藏网址
     * @param name
     * @param link
     * @return
     */
    @POST("lg/collect/addtool/json")
    public Flowable<WanAndroidResponse<WanAndroidFriend>> addCollectSite(@Field("name") String name,@Field("link") String link);

    /**
     * 6.7编辑收藏网站
     * @param id
     * @param name
     * @param link
     * @return
     */
    @POST("lg/collect/updatetool/json")
    public Flowable<WanAndroidResponse<WanAndroidFriend>> updateCollectSite(@Field("id") int id,@Field("name") String name,@Field("link") String link);

    /**
     * 6.8 删除收藏网站
     * @param id
     * @return
     */
    @POST("lg/collect/deletetool/json")
    public Flowable<WanAndroidResponse<WanAndroidFriend>> deleteCollectSite(@Field("id") int id);

    /**
     * 7.1 搜索
     * @param key
     * @return
     */
    @POST("article/query/{page}/json")
    public Flowable<WanAndroidResponse<WanAndroidData>> search(@Field("k") String key,@Path("page") int page);
}

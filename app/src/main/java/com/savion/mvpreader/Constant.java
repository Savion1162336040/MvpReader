package com.savion.mvpreader;

import android.os.Environment;

import java.io.File;

/**
 * Created by Administrator on 2017-12-29.
 */

public class Constant {
    public static final String TAG = "savion";
    public static final String JUHE_NEWS_APPKEY = "192bc976d907659b9a337857eafc1b2f";


    //base path
    public static final String BASE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"MvpReader";
    //cache path
    public static final String CACHE_PATH = BASE_PATH+File.separator+"cache";
    //img path
    public static final String IMG_PATH = BASE_PATH+File.separator+"img";



}

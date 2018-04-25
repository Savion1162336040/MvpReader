package com.example.mvpreaderjava.modle.exception;

/**
 * Created by sw116 on 2018/4/25.
 * 本地api错误
 */
public class ApiException extends RuntimeException {
    public ApiException(){
        super();
    }

    public ApiException(String msg){
        super(msg);
    }
}

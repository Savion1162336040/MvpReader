package com.savion.mvpreader.model.exception;

/**
 * Created by savion on 2018/4/11.
 */

public class ApiException2 extends RuntimeException {

    private int code;

    public ApiException2() {
        super("未知的api异常");
        code = -100;
    }

    public ApiException2(String msg) {
        super(msg);
        code = -100;
    }

    public ApiException2(int code, String msg) {
        super(msg);
        this.code = code;
    }


}

package com.example.mvpreaderjava.modle.exception;

/**
 * 数据空异常
 */
public class DataEmptyException extends RuntimeException {
    private int code;

    public DataEmptyException() {
        super();
    }

    public DataEmptyException(String msg) {
        super(msg);
    }

    public DataEmptyException(int code, String msg) {
        super(msg);
        this.code = code;
    }

}

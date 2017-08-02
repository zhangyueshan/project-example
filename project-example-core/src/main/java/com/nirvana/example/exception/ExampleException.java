package com.nirvana.example.exception;

public class ExampleException extends RuntimeException {

    private String errorCode;

    private String msg;

    public ExampleException() {
        this(ResultCode.FAILURE);
    }

    public ExampleException(ResultCode errorCode) {
        super(errorCode.getDesc());
        this.errorCode = errorCode.getCode();
        this.msg = errorCode.getDesc();
    }

    public ExampleException(ResultCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode.getCode();
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMsg() {
        return msg;
    }
}

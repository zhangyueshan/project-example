package com.nirvana.example.exception;

import com.nirvana.web.common.api.Result;

/**
 * 返回码。
 */
public enum ResultCode implements Result {

    SUCCESS("000000", "成功"),
    FAILURE("999999", "失败");

    ResultCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;

    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

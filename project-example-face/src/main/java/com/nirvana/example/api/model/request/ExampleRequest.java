package com.nirvana.example.api.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel("示例请求")
public class ExampleRequest {

    @NotBlank(message = "请求消息不能为空")
    @ApiModelProperty(value = "请求消息", required = true)
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

package com.nirvana.example.controller;

import com.nirvana.example.api.ApiResponseUtils;
import com.nirvana.example.api.model.request.ExampleRequest;
import com.nirvana.example.model.user.User;
import com.nirvana.example.service.user.UserService;
import com.nirvana.web.common.api.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ApiOperation("测试")
    public ApiResponse<String> test(@RequestBody @Valid ExampleRequest request) {
        return new ApiResponse<>("000000", "成功", "data!");
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ApiOperation("获取用户信息")
    public ApiResponse<User> getUser() {
        User user = userService.get(1);
        return ApiResponseUtils.success(user);
    }


}

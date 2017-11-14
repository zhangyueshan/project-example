package com.nirvana.example.controller;

import com.github.pagehelper.Page;
import com.nirvana.example.api.model.request.ExampleRequest;
import com.nirvana.example.exception.ResultCode;
import com.nirvana.example.model.user.User;
import com.nirvana.example.service.user.UserService;
import com.nirvana.web.common.api.ApiResponse;
import com.nirvana.web.common.api.ApiResponseUtils;
import com.nirvana.web.common.api.BaseApiException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.OptimisticLockException;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ApiOperation("测试")
    public ApiResponse<User> test(@RequestBody @Valid ExampleRequest request) {
        User user = userService.get(request.getId());
        return ApiResponseUtils.success(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ApiOperation("获取用户信息")
    public ApiResponse<List<User>> getUser() {
        Page<User> user = userService.get(1, 10);
        return ApiResponseUtils.success(user);
    }

    @RequestMapping(value = "/deduct", method = RequestMethod.POST)
    @ApiOperation("扣款")
    public ApiResponse deduct() {

        boolean success = false;
        int retryTimes = 0;
        while (!success) {
            try {
                userService.deduct("tom", new BigDecimal(13.5));
                success = true;
            } catch (OptimisticLockException e) {
                //重试超过三次。
                if (retryTimes >= 3) {
                    throw new BaseApiException(ResultCode.FAILURE, "服务器忙");
                }
                retryTimes++;
            }
        }

        return ApiResponseUtils.success();
    }


}

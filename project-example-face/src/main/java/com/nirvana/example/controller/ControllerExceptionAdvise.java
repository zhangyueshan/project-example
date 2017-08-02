package com.nirvana.example.controller;

import com.nirvana.example.api.ApiResponseUtils;
import com.nirvana.web.common.api.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 异常处理
 */
@ControllerAdvice
public class ControllerExceptionAdvise {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionAdvise.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponse handlerException(Exception ex) {
        LOGGER.error("错误：", ex);
        return ApiResponseUtils.failure();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        LOGGER.error("参数验证错误：", ex);
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        ObjectError error = errors.get(0);
        return ApiResponseUtils.failure(error.getDefaultMessage());
    }


}

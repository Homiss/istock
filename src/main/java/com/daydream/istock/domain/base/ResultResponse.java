package com.daydream.istock.domain.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 响应结果封装
 */

public class ResultResponse {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    // 只返回状态
    public static Result getSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    // 成功返回数据
    public static Result getSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    // 失败
    public static Result getFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}

package com.momshop.mom_shop.common.api;

import lombok.AllArgsConstructor;

/**
 * @Author Antique
 * @Date 2022/1/24 14:49
 * @Version 1.0
 */
@AllArgsConstructor
public enum ResultCode implements ICode{
    /**
     * all status code
     */
    SUCCESS(200,"操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private long code;
    private String message;


    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

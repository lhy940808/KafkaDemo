package com.lhy.boot.common.resp;

import lombok.Data;

/**
 * @author liuhaiyan
 * @date 2020-11-17 11:07
 */
@Data
public class BaseResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}


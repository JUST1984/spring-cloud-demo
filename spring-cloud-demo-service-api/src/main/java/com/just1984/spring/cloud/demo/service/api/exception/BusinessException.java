package com.just1984.spring.cloud.demo.service.api.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-26 20:40
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

}

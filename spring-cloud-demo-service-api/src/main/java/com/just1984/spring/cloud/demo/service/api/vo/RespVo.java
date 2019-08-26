package com.just1984.spring.cloud.demo.service.api.vo;

import lombok.Data;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-15 21:31
 */
@Data
public class RespVo<T> {

    private T data;

    public static RespVo data(Object data) {
        RespVo respVo = new RespVo();
        respVo.setData(data);
        return respVo;
    }

}

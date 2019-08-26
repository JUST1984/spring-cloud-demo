package com.just1984.spring.cloud.demo.service.api.vo;

import lombok.Data;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-15 21:29
 */
@Data
public class ReqVo<T> {

    private T data;

    public static ReqVo data(Object data) {
        ReqVo reqVo = new ReqVo();
        reqVo.setData(data);
        return reqVo;
    }

}

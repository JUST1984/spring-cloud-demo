package com.just1984.spring.cloud.demo.service.consumer.controller;

import com.just1984.spring.cloud.demo.service.api.sdk.ProviderApi;
import com.just1984.spring.cloud.demo.service.api.vo.ReqVo;
import com.just1984.spring.cloud.demo.service.api.vo.RespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-15 21:22
 */
@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ProviderApi providerApi;

    @PostMapping("data")
    public RespVo data(@RequestBody ReqVo reqVo) {
        return providerApi.data(reqVo);
    }

}

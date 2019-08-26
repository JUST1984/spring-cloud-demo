package com.just1984.spring.cloud.demo.service.provider.controller;

import com.just1984.spring.cloud.demo.service.api.vo.ReqVo;
import com.just1984.spring.cloud.demo.service.api.vo.RespVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-15 21:18
 */
@RestController
@RequestMapping("provider")
public class ProviderController {

    @PostMapping("message")
    public RespVo message(@RequestBody ReqVo reqVo) {
        RespVo respVo = new RespVo();
        respVo.setMessage(reqVo.getMessage());
        return respVo;
    }

}

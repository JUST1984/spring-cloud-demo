package com.just1984.spring.cloud.demo.service.consumer.controller;

import com.just1984.spring.cloud.demo.service.api.vo.ReqVo;
import com.just1984.spring.cloud.demo.service.api.vo.RespVo;
import com.just1984.spring.cloud.demo.service.consumer.hystrix.ConsumerHystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-15 21:22
 */
@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("message")
    public RespVo message(String message) {
        ConsumerHystrixCommand command = new ConsumerHystrixCommand(restTemplate, ReqVo.data(message));
        return command.execute();
    }

}

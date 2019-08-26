package com.just1984.spring.cloud.demo.service.consumer.controller;

import com.just1984.spring.cloud.demo.service.api.vo.ReqVo;
import com.just1984.spring.cloud.demo.service.api.vo.RespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${role}")
    private String role;

    @GetMapping("message")
    public RespVo message(String message) {
        return restTemplate.postForObject("http://spring-cloud-demo-service-provider/provider/data", ReqVo.data(message), RespVo.class);
    }

    @GetMapping("role")
    public RespVo role() {
        return message(role);
    }

}

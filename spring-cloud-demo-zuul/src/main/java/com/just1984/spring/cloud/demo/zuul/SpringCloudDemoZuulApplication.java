package com.just1984.spring.cloud.demo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: Zuul Proxy
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-03 19:45
 */
@RestController
@EnableZuulProxy
@SpringCloudApplication
public class SpringCloudDemoZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoZuulApplication.class, args);
    }

    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }

}

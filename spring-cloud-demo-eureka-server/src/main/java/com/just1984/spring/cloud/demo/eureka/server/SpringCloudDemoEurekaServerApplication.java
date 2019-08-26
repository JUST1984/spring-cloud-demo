package com.just1984.spring.cloud.demo.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description: 服务注册中心
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-26 19:25
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudDemoEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoEurekaServerApplication.class, args);
    }

}

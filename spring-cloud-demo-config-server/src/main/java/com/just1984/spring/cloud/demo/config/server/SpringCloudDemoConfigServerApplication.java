package com.just1984.spring.cloud.demo.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description: 统一配置中心
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-26 19:38
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class SpringCloudDemoConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoConfigServerApplication.class, args);
    }

}

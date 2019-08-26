package com.just1984.spring.cloud.demo.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: 服务提供方
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-26 19:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudDemoServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoServiceProviderApplication.class, args);
    }

}

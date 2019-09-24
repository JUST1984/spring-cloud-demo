package com.just1984.spring.cloud.demo.service.provider;

import com.just1984.spring.cloud.demo.service.api.mq.SpringCloudDemoProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @description: 服务提供方
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-26 19:56
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableBinding(SpringCloudDemoProcessor.class)
@RemoteApplicationEventScan(basePackages = {"com.just1984.spring.cloud.demo.service.api.bus"})
public class SpringCloudDemoServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoServiceProviderApplication.class, args);
    }

}

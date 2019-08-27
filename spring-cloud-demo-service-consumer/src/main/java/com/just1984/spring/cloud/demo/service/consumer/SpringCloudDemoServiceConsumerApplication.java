package com.just1984.spring.cloud.demo.service.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @description: 服务消费者
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-26 20:12
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient("spring-cloud-demo-service-provider")
@EnableCircuitBreaker
public class SpringCloudDemoServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoServiceConsumerApplication.class, args);
    }

}

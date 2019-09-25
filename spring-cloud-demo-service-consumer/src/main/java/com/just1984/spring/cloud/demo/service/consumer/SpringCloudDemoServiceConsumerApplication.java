package com.just1984.spring.cloud.demo.service.consumer;

import com.just1984.spring.cloud.demo.service.api.mq.SpringCloudDemoProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @description: 服务消费者
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-26 20:12
 */
@RibbonClient("${spring-cloud-demo-service-provider.application.name}")
@EnableFeignClients(basePackages = {"com.just1984.spring.cloud.demo.service.api.sdk"})
@SpringBootApplication(scanBasePackages = {"com.just1984.spring.cloud.demo.service.consumer", "com.just1984.spring.cloud.demo.service.api"})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableBinding(SpringCloudDemoProcessor.class)
@RemoteApplicationEventScan(basePackages = {"com.just1984.spring.cloud.demo.service.api.bus"})
public class SpringCloudDemoServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoServiceConsumerApplication.class, args);
    }

}

package com.just1984.spring.cloud.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-15 16:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudDemoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoGatewayApplication.class, args);
    }

}

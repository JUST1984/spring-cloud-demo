package com.just1984.spring.cloud.demo.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-27 20:22
 */
@SpringBootApplication
@EnableHystrixDashboard
public class SpringCloudDemoHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoHystrixDashboardApplication.class, args);
    }

}

package com.just1984.spring.cloud.demo.service.consumer.test;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-28 16:15
 */
public class TestMain {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shut down");
        }));
    }

}

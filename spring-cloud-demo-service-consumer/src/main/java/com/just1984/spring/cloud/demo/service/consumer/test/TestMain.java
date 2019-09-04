package com.just1984.spring.cloud.demo.service.consumer.test;

import lombok.Data;
import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-28 16:15
 */
public class TestMain {

    @Data
    private static class User {

        private String name;

        private int age;

    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("JUST1984");
        user.setAge(20);
        Map<String, Object> map = new HashMap<>(1 << 4);
        BeanMap beanMap = BeanMap.create(user);
        map.putAll(beanMap);
        System.out.println(map);
    }

}

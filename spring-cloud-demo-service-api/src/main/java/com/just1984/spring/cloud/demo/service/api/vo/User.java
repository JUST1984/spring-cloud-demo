package com.just1984.spring.cloud.demo.service.api.vo;

import lombok.Data;

import java.util.UUID;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-03 21:53
 */
@Data
public class User {

    private String id;

    private String name;

    private int age;

    private boolean gender;

    public User(String name, int age, boolean gender) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

}

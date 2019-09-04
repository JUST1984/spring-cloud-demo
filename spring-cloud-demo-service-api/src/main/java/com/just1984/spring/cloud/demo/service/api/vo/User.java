package com.just1984.spring.cloud.demo.service.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-03 21:53
 */
@Data
@AllArgsConstructor
public class User {

    private String name;

    private int age;

    private boolean gender;

}

package com.just1984.spring.cloud.demo.service.consumer.service;

import com.just1984.spring.cloud.demo.service.api.vo.User;

import java.util.List;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-09 10:58
 */
public interface ClientService {

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();

    /**
     * 清空用户列表
     */
    void clear();

}

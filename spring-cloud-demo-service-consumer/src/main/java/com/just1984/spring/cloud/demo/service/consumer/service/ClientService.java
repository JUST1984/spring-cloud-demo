package com.just1984.spring.cloud.demo.service.consumer.service;

import com.just1984.spring.cloud.demo.service.api.sdk.ProviderApi;
import com.just1984.spring.cloud.demo.service.api.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-04 14:05
 */
@Slf4j
@Service
public class ClientService {

    @Autowired
    private ProviderApi providerApi;

    public void addUser(User user) {
        providerApi.addUser(user);
    }

    public List<User> getUserList() {
        return providerApi.getUserList();
    }

    @Async
    public void testAsync() {
        log.info(Thread.currentThread().getName());
    }

}

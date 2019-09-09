package com.just1984.spring.cloud.demo.service.consumer.service;

import com.just1984.spring.cloud.demo.service.api.sdk.ProviderApi;
import com.just1984.spring.cloud.demo.service.api.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-04 14:05
 */
@Slf4j
@Service
@Qualifier("restClientService")
public class RestClientServiceImpl implements ClientService {

    @Autowired
    private ProviderApi providerApi;

    @Override
    public void addUser(User user) {
        providerApi.addUser(user);
    }

    @Override
    public List<User> getUserList() {
        return providerApi.getUserList();
    }

}

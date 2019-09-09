package com.just1984.spring.cloud.demo.service.provider.service;

import com.just1984.spring.cloud.demo.service.api.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-03 21:35:53
 */
@Service
public class RestProviderServiceImpl implements ProviderService {

    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users.add(new User("JUST1984", 25, true));
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getUserList() {
        return users;
    }

}

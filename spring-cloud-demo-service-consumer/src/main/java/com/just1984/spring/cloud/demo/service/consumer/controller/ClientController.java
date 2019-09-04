package com.just1984.spring.cloud.demo.service.consumer.controller;

import com.just1984.spring.cloud.demo.service.api.sdk.ProviderApi;
import com.just1984.spring.cloud.demo.service.api.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-15 21:22
 */
@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ProviderApi providerApi;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        providerApi.addUser(user);
    }

    @GetMapping("/getUserList")
    public List<User> getUserList() {
        return providerApi.getUserList();
    }

}

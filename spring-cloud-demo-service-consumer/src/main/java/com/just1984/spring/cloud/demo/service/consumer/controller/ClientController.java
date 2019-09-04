package com.just1984.spring.cloud.demo.service.consumer.controller;

import com.just1984.spring.cloud.demo.service.api.vo.User;
import com.just1984.spring.cloud.demo.service.consumer.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-15 21:22
 */
@Slf4j
@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private Executor executor;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        clientService.addUser(user);
    }

    @GetMapping("/getUserList")
    public List<User> getUserList() {
        return clientService.getUserList();
    }

    @GetMapping("testAsync")
    public void testAsync() {
        executor.execute(() -> {
            log.info(Thread.currentThread().getName());
        });
        clientService.testAsync();
    }

}

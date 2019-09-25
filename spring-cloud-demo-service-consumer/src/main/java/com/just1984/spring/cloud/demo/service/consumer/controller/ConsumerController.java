package com.just1984.spring.cloud.demo.service.consumer.controller;

import com.just1984.spring.cloud.demo.service.api.vo.User;
import com.just1984.spring.cloud.demo.service.consumer.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-15 21:22
 */
@Slf4j
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    @Qualifier("kafkaClientService")
    private ClientService kafkaClientService;

    @Autowired
    @Qualifier("restClientService")
    private ClientService restClientService;

    @Autowired
    @Qualifier("remoteEventClientService")
    private ClientService remoteEventClientService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        restClientService.addUser(user);
    }

    @PostMapping("/addUserAsync")
    public void addUserAsync(@RequestBody User user) {
        kafkaClientService.addUser(user);
    }

    @PostMapping("/addUserEvent")
    public void addUserEvent(@RequestBody User user) {
        remoteEventClientService.addUser(user);
    }

    @GetMapping("/getUserList")
    public List<User> getUserList() {
        return restClientService.getUserList();
    }

    @GetMapping("/clear")
    public void clear() {}

}

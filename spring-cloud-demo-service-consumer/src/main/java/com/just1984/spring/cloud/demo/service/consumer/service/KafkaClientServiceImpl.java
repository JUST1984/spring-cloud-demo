package com.just1984.spring.cloud.demo.service.consumer.service;

import com.just1984.spring.cloud.demo.service.api.mq.SpringCloudDemoProcessor;
import com.just1984.spring.cloud.demo.service.api.sdk.ProviderApi;
import com.just1984.spring.cloud.demo.service.api.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-09 11:02
 */
@Slf4j
@Service
@Qualifier("kafkaClientService")
public class KafkaClientServiceImpl implements ClientService {

    @Autowired
    private SpringCloudDemoProcessor processor;

    @Autowired
    private ProviderApi providerApi;

    @Override
    public void addUser(User user) {
        MessageChannel outputChannel = processor.output();
        outputChannel.send(MessageBuilder.withPayload(user).build());
    }

    @Override
    public List<User> getUserList() {
        return providerApi.getUserList();
    }

}

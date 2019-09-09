package com.just1984.spring.cloud.demo.service.consumer.service;

import com.just1984.spring.cloud.demo.service.api.mq.MqConstant;
import com.just1984.spring.cloud.demo.service.api.sdk.ProviderApi;
import com.just1984.spring.cloud.demo.service.api.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

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
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private ProviderApi providerApi;

    @Override
    public void addUser(User user) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(MqConstant.DEFAULT_TOPIC, MqConstant.ADD_USER_KEY, user);
        future.addCallback(res -> {
            log.info("send message success : 【{}】", res.toString());
        }, res -> {
            log.error("send message error : 【{}】", res.toString());
        });
    }

    @Override
    public List<User> getUserList() {
        return providerApi.getUserList();
    }

}

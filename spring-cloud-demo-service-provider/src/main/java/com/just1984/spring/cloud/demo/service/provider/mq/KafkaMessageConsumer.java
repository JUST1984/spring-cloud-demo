package com.just1984.spring.cloud.demo.service.provider.mq;

import com.alibaba.fastjson.JSONObject;
import com.just1984.spring.cloud.demo.service.api.mq.MqConstant;
import com.just1984.spring.cloud.demo.service.api.vo.User;
import com.just1984.spring.cloud.demo.service.provider.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-09 11:30
 */
@Slf4j
@Component
public class KafkaMessageConsumer {

    @Autowired
    private ProviderService providerService;

    @KafkaListener(topics = {MqConstant.DEFAULT_TOPIC})
    public void handle(ConsumerRecord<String, Object> record) {
        log.info("receive kafka message : 【{}】", record.toString());
        if (MqConstant.ADD_USER_KEY.equals(record.key())) {
            User user = JSONObject.parseObject(record.value().toString(), User.class);
            providerService.addUser(user);
        }
    }

}

package com.just1984.spring.cloud.demo.service.provider.mq;

import com.alibaba.fastjson.JSONObject;
import com.just1984.spring.cloud.demo.service.api.mq.SpringCloudDemoProcessor;
import com.just1984.spring.cloud.demo.service.api.vo.User;
import com.just1984.spring.cloud.demo.service.provider.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
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

    @StreamListener(SpringCloudDemoProcessor.INPUT)
    public void handle(Message<?> message) {
        User user = JSONObject.parseObject(message.getPayload().toString(), User.class);
        providerService.addUser(user);
    }

}

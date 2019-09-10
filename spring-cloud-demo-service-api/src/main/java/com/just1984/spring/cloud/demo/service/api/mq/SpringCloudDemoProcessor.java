package com.just1984.spring.cloud.demo.service.api.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-10 16:35
 */
public interface SpringCloudDemoProcessor {

    String OUTPUT = "springCloudDemoOutput";

    String INPUT = "springCloudDemoInput";

    /**
     * 消息生产
     * @return
     */
    @Output(SpringCloudDemoProcessor.OUTPUT)
    MessageChannel output();

    /**
     * 消息消费
     * @return
     */
    @Input(SpringCloudDemoProcessor.INPUT)
    SubscribableChannel input();

}

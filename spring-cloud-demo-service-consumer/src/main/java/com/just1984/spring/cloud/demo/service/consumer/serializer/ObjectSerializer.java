package com.just1984.spring.cloud.demo.service.consumer.serializer;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-09 14:03:43
 */
public class ObjectSerializer implements Serializer<Object> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Object data) {
        return JSONObject.toJSONString(data).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public void close() {

    }

}

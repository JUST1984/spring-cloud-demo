package com.just1984.spring.cloud.demo.service.provider.serializer;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-09-09 14:04:16
 */
public class ObjectDeserializer implements Deserializer<Object> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        return JSONObject.parseObject(new String(data, StandardCharsets.UTF_8), Object.class);
    }

    @Override
    public void close() {

    }

}

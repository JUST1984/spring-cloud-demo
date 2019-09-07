package com.just1984.spring.cloud.demo.service.consumer.serializer;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Slf4j
public class ObjectSerializer implements Serializer<Object> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Object data) {
        try {
            return JSONObject.toJSONString(data).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("data serialize error", e);
        }
        return new byte[0];
    }

    @Override
    public void close() {

    }

}

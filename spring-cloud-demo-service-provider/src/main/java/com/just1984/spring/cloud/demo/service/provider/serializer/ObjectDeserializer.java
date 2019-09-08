package com.just1984.spring.cloud.demo.service.provider.serializer;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class ObjectDeserializer implements Deserializer<Object> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        try {
            return JSONObject.parseObject(new String(data, "UTF-8"), Object.class);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    @Override
    public void close() {

    }

}

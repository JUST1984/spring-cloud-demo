package com.just1984.spring.cloud.demo.service.provider.bus;

import com.alibaba.fastjson.JSONObject;
import com.just1984.spring.cloud.demo.service.api.bus.AddUserRemoteApplicationEvent;
import com.just1984.spring.cloud.demo.service.provider.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.event.EnvironmentChangeRemoteApplicationEvent;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-24 19:49
 */
@Slf4j
@Configuration
public class RemoteApplicationEventListenerConfiguration {

    @Autowired
    private ProviderService providerService;

    @EventListener(RefreshRemoteApplicationEvent.class)
    public void onRefreshRemoteApplicationEvent(RefreshRemoteApplicationEvent event) {
        log.info("监听到RefreshRemoteApplicationEvent事件：【{}】", JSONObject.toJSONString(event));
    }

    @EventListener(EnvironmentChangeRemoteApplicationEvent.class)
    public void onEnvironmentChangeRemoteApplicationEvent(EnvironmentChangeRemoteApplicationEvent event) {
        log.info("监听到EnvironmentChangeRemoteApplicationEvent事件：【{}】", JSONObject.toJSONString(event));
    }

    @EventListener(AddUserRemoteApplicationEvent.class)
    public void onAddUserRemoteApplicationEvent(AddUserRemoteApplicationEvent event) {
        log.info("监听到AddUserRemoteApplicationEvent事件：【{}】", JSONObject.toJSONString(event));
        providerService.addUser(event.getUser());
    }

}

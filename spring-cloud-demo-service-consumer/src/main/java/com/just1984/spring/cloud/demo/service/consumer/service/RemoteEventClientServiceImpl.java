package com.just1984.spring.cloud.demo.service.consumer.service;

import com.just1984.spring.cloud.demo.service.api.bus.AddUserRemoteApplicationEvent;
import com.just1984.spring.cloud.demo.service.api.sdk.ProviderApi;
import com.just1984.spring.cloud.demo.service.api.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-24 20:55
 */
@Service
@Qualifier("remoteEventClientService")
public class RemoteEventClientServiceImpl implements ClientService {

    @Value("${spring-cloud-demo-service-provider.application.name}")
    private String destinationService;

    @Autowired
    private ProviderApi providerApi;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private BusProperties busProperties;

    @Override
    public void addUser(User user) {
        publisher.publishEvent(new AddUserRemoteApplicationEvent(this, busProperties.getId(), destinationService + ":**", user));
    }

    @Override
    public List<User> getUserList() {
        return providerApi.getUserList();
    }

    @Override
    public void clear() {
        providerApi.clear();
    }

}

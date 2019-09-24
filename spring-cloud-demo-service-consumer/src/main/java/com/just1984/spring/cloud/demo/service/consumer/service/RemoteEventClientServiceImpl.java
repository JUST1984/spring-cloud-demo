package com.just1984.spring.cloud.demo.service.consumer.service;

import com.just1984.spring.cloud.demo.service.api.bus.AddUserRemoteApplicationEvent;
import com.just1984.spring.cloud.demo.service.api.sdk.ProviderApi;
import com.just1984.spring.cloud.demo.service.api.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    private ProviderApi providerApi;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private BusProperties busProperties;

    @Override
    public void addUser(User user) {
        publisher.publishEvent(new AddUserRemoteApplicationEvent(user, busProperties.getId()));
    }

    @Override
    public List<User> getUserList() {
        return providerApi.getUserList();
    }

}

package com.just1984.spring.cloud.demo.service.api.sdk;

import com.google.common.collect.Lists;
import com.just1984.spring.cloud.demo.service.api.vo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-30 10:22
 */
@FeignClient(
        name = "${spring-cloud-demo-service-provider.application.name}",
        path = "/provider",
        fallback = ProviderApi.ProviderApiFallback.class
)
public interface ProviderApi {

    /**
     * 添加用户
     * @param user
     */
    @PostMapping("/addUser")
    void addUser(User user);

    /**
     * 获取用户列表
     * @return
     */
    /*@HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            }
    )*/
    @GetMapping("/getUserList")
    List<User> getUserList();

    @Component
    class ProviderApiFallback implements ProviderApi {

        @Override
        public void addUser(User user) {}

        @Override
        public List<User> getUserList() {
            return Lists.newArrayList();
        }

    }

}

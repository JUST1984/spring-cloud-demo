package com.just1984.spring.cloud.demo.service.api.sdk;

import com.google.common.collect.Lists;
import com.just1984.spring.cloud.demo.service.api.vo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
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
        fallbackFactory = ProviderApi.ProviderApiFallbackFactory.class
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
    @GetMapping("/getUserList")
    List<User> getUserList();

    /**
     * 清空用户列表
     */
    @GetMapping("/clear")
    void clear();

    @Slf4j
    @Component
    class ProviderApiFallbackFactory implements FallbackFactory<ProviderApi> {

        @Override
        public ProviderApi create(Throwable e) {
            log.error("触发服务降级", e);
            return new ProviderApiFallback();
        }

    }

    class ProviderApiFallback implements ProviderApi {

        @Override
        public void addUser(User user) {}

        @Override
        public List<User> getUserList() {
            return Lists.newArrayList();
        }

        @Override
        public void clear() {}

    }

}

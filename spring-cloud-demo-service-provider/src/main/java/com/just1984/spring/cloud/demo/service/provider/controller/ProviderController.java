package com.just1984.spring.cloud.demo.service.provider.controller;

import com.just1984.spring.cloud.demo.service.api.exception.BusinessException;
import com.just1984.spring.cloud.demo.service.api.sdk.ProviderApi;
import com.just1984.spring.cloud.demo.service.api.vo.ReqVo;
import com.just1984.spring.cloud.demo.service.api.vo.RespVo;
import com.just1984.spring.cloud.demo.service.provider.service.ProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-15 21:18
 */
@Slf4j
@RestController
@RequestMapping("provider")
public class ProviderController implements ProviderApi {

    private static final Random random = new Random();

    @Autowired
    private ProviderService providerService;

    @HystrixCommand(
            commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            },
            fallbackMethod = "fallbackForData"
    )
    @Override
    public RespVo data(@RequestBody ReqVo reqVo) {
        int cost = random.nextInt(200);
        log.info("cost: {} ms", cost);
        try {
            Thread.sleep(cost);
        } catch (InterruptedException e) {}
        return providerService.data(reqVo);
    }

    public RespVo fallbackForData(ReqVo reqVo) {
        return RespVo.data("default");
    }

    @RequestMapping("exception")
    public RespVo exception() {
        throw new BusinessException("BusinessException");
    }

}

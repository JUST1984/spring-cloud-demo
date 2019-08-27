package com.just1984.spring.cloud.demo.service.consumer.hystrix;

import com.just1984.spring.cloud.demo.service.api.vo.ReqVo;
import com.just1984.spring.cloud.demo.service.api.vo.RespVo;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-27 16:30
 */
public class ConsumerHystrixCommand extends HystrixCommand<RespVo> {

    private RestTemplate restTemplate;

    private ReqVo reqVo;

    public ConsumerHystrixCommand(RestTemplate restTemplate, ReqVo reqVo) {
        super(HystrixCommandGroupKey.Factory.asKey("spring-cloud-demo-service-provider"), 200);
        this.restTemplate = restTemplate;
        this.reqVo = reqVo;
    }

    @Override
    protected RespVo run() throws Exception {
        return restTemplate.postForObject("http://spring-cloud-demo-service-provider/provider/data", reqVo, RespVo.class);
    }

    @Override
    protected RespVo getFallback() {
        return RespVo.data("client default");
    }
}

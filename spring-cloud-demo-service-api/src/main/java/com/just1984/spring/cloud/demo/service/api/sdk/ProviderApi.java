package com.just1984.spring.cloud.demo.service.api.sdk;

import com.just1984.spring.cloud.demo.service.api.vo.ReqVo;
import com.just1984.spring.cloud.demo.service.api.vo.RespVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-30 10:22
 */
@FeignClient(name = "spring-cloud-demo-service-provider", path = "/provider")
public interface ProviderApi {

    /**
     * provider data
     * @param reqVo
     * @return
     */
    @PostMapping("/data")
    RespVo data(ReqVo reqVo);

}

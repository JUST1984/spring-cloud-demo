package com.just1984.spring.cloud.demo.service.provider.service;

import com.just1984.spring.cloud.demo.service.api.sdk.ProviderApi;
import com.just1984.spring.cloud.demo.service.api.vo.ReqVo;
import com.just1984.spring.cloud.demo.service.api.vo.RespVo;
import org.springframework.stereotype.Service;

@Service
public class ProviderService implements ProviderApi {

    @Override
    public RespVo data(ReqVo reqVo) {
        return RespVo.data(reqVo.getData());
    }

}

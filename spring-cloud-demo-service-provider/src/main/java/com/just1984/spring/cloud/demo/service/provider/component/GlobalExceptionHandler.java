package com.just1984.spring.cloud.demo.service.provider.component;

import com.just1984.spring.cloud.demo.service.api.exception.BusinessException;
import com.just1984.spring.cloud.demo.service.api.vo.RespVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-26 20:42
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public RespVo handleBusinessException(BusinessException e) {
        log.error("Catch BusinessException :", e);
        return RespVo.data(e.getMessage());
    }

}

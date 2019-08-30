package com.just1984.spring.cloud.demo.service.consumer.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-29 14:47
 */
public abstract class AbstractCommand<T> {

    public T execute() {
        CompletableFuture<T> future = CompletableFuture.supplyAsync(() -> target());
        try {
            return future.get(100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            return fallback();
        }
    }

    /**
     * 目标方法
     * @return
     */
    protected abstract T target();

    /**
     * 降级方法
     * @return
     */
    protected abstract T fallback();

}

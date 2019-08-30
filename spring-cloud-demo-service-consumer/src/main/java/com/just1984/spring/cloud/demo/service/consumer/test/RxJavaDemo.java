package com.just1984.spring.cloud.demo.service.consumer.test;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Arrays;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-29 19:20
 */
public class RxJavaDemo {

    public static void main(String[] args) throws InterruptedException {
        Observable.from(Arrays.asList(1, 2, 3, 4, 5))
                .subscribeOn(Schedulers.computation())
                .subscribe(System.out::println);

        Thread.sleep(1000);
    }

}

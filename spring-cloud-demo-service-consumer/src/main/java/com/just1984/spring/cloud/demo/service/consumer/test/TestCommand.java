package com.just1984.spring.cloud.demo.service.consumer.test;

/**
 * @description:
 * @author: zhangyifan@wshifu.com
 * @date: 2019-08-29 15:00
 */
public class TestCommand extends AbstractCommand<String> {

    @Override
    protected String target() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "target";
    }

    @Override
    protected String fallback() {
        return "fallback";
    }

    public static void main(String[] args) {
        TestCommand command = new TestCommand();
        String res = command.execute();
        System.out.println(res);
    }

}

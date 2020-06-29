package com.lhy.boot.service.impl;

import com.lhy.boot.service.MockQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.concurrent.Future;

/**
 * @author liuhaiyan
 * @date 2020-06-19 14:35
 */

@Service
@Slf4j
public class MockQueryServiceImpl implements MockQueryService {

    @Async("homeDataTaskExecutor")
    @Override
    public Future<Integer> queryA(String parentThreadName) {
        log.info("queryA begin--------------,parentname:{}---", parentThreadName);
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("queryA end---------------,pname:{}cost:{}ms", parentThreadName, System.currentTimeMillis() - startTime);
        return new AsyncResult<>(1);
    }

    @Async("homeDataTaskExecutor")
    @Override
    public Future<Integer> queryB(String parentThreadName) {
        log.info("queryB begin---------------name:{}", parentThreadName);
        long startime = System.currentTimeMillis();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("queryB end---------------,pname:{} cost:{}ms", parentThreadName, System.currentTimeMillis() - startime);
        return new AsyncResult<>(2);
    }

    @Async("homeDataTaskExecutor")
    @Override
    public Future<Integer> queryC(String parentThreadName) {

        log.info("queryC begin---------------,pname:{}", parentThreadName);
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("queryC end---------------,pname:{},cost:{}ms", parentThreadName, System.currentTimeMillis() - startTime);
        return new AsyncResult<>(3);
    }

    @Async("homeDataTaskExecutor")
    @Override
    public Future<Integer> queryD(String parentThreadName) {
        log.info("querrD begin---------------,pname:{}", parentThreadName);
        long startTIme = System.currentTimeMillis();
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("queryD end---------------,pname:{},cost:{}ms", parentThreadName, System.currentTimeMillis() - startTIme);
        return new AsyncResult<>(4);

    }
}

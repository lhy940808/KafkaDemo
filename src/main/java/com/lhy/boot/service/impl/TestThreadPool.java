package com.lhy.boot.service.impl;

import com.lhy.boot.service.MockQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author liuhaiyan
 * @date 2020-06-19 14:39
 */
@Service
@Slf4j
public class TestThreadPool {

    @Autowired
    private MockQueryService mockQueryService;

    public void test() {
        log.info("begin test-----------------------");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long startTime = System.currentTimeMillis();
        // 调用方法
        Future<Integer> resA = mockQueryService.queryA(Thread.currentThread().getName());
        Future<Integer> resB = mockQueryService.queryB(Thread.currentThread().getName());
        Future<Integer> resC = mockQueryService.queryC(Thread.currentThread().getName());
        Future<Integer> resD = mockQueryService.queryD(Thread.currentThread().getName());

        try {
            resA.get();
            resB.get();
            resD.get();
            resC.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        log.info("end test-----------------------cost:{}", System.currentTimeMillis() - startTime);
    }
}

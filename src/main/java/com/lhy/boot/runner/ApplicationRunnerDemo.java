package com.lhy.boot.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author liuhaiyan
 * @date 2019-12-03 20:52
 */
@Component
public class ApplicationRunnerDemo implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("applicationrunner begin run-------");
        System.out.println("applicationrunner end run----");

    }
}

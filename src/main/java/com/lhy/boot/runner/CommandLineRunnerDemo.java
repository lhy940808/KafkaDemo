package com.lhy.boot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * ApplicationRunner与CommandLineRunner的应用
 * ApplicationRunner会先运行
 * @author liuhaiyan
 * @date 2019-12-03 20:48
 */
@Component
public class CommandLineRunnerDemo implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        System.out.println("commadnLineRunner -----begin run");
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println("commandlinerunner end----");
    }
}

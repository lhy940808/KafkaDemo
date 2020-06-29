package com.lhy.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author liuhaiyan
 * @date 2019-10-30 14:51
 */
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
@MapperScan("com.lhy.boot.dao")
@EnableAsync
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}

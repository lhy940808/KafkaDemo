package com.lhy.boot;

import com.lhy.boot.kafka.provider.KafkaSender;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author liuhaiyan
 * @date 2019-10-30 14:51
 */
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
@MapperScan("com.lhy.boot.dao")
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);

        KafkaSender sender = context.getBean(KafkaSender.class);
        for(int i = 0; i < 3; i++) {
            //发送消息
            sender.send();
            try {
                Thread.sleep(1000);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

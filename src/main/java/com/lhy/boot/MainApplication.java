package com.lhy.boot;

import com.lhy.boot.kafka.provider.KafkaSender;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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


        // 以下为测试方法
//        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//        List<Integer> newLists = list.stream().map(ele -> getList(ele)).flatMap(List::stream).collect(Collectors.toList());
//        System.out.println(newLists);

    }
    public static List<Integer> getList(Integer e) {
        return Arrays.asList(e+1, e+2, e+3);
    }
}

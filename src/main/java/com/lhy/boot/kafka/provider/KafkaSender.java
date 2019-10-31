package com.lhy.boot.kafka.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lhy.boot.kafka.beans.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * 消息发送着
 * @author liuhaiyan
 * @date 2019-10-31 11:41
 */
@Slf4j
@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        log.info("-----------begin send msg------");
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        /*
        * kafkaTemplate.send() 方法，zhisheng 是 Kafka 里的 topic ，这个 topic 在 Java 程序中是不需要提前在 Kafka 中设置的，
        * 因为它会在发送的时候自动创建你设置的 topic， gson.toJson(message) 是消息内容
        * */
        kafkaTemplate.send("lhy", gson.toJson(message));
    }
}

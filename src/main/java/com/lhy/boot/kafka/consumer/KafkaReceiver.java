package com.lhy.boot.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 消息的消费者
 * @author liuhaiyan
 * @date 2019-10-31 11:41
 */
@Slf4j
@Component
public class KafkaReceiver {

    @KafkaListener(topics={"lhy"})
    public void listen(ConsumerRecord<?, ?> record) {
        log.info("--------begin consumer msg ----------");
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("------------------ record is {}", record);
            log.info("+++++++++++++++++++ message is {}", message);
        }
    }

}

package com.lhy.boot.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhaiyan
 * @date 2019-10-30 21:32
 */
@Slf4j
@RestController
public class KafkaProducer {

    @RequestMapping("/send/{msg}")
    public String sendMsg(@PathVariable(value="msg") String msg) {
        log.info("begin sendmsg, msg is {}", msg);
        return "ok";
    }

}

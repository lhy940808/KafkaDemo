package com.lhy.boot.kafka.beans;

import lombok.Data;

import java.util.Date;

/**
 * 消息实体
 * @author liuhaiyan
 * @date 2019-10-31 11:40
 */
@Data
public class Message {

    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳

}


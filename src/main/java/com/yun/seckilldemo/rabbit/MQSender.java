package com.yun.seckilldemo.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wanglufei
 * 消息发送者
 * @title: MQSender
 * @projectName seckill-demo
 * @description: TODO
 * @date 2021/11/8/3:28 下午
 */
@Service
@Slf4j
public class MQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Object msg){
        log.info("发送消息"+msg);
        //将消息发送到交换机
        rabbitTemplate.convertAndSend("fanoutExchange","",msg);
    }

    public void send01(Object msg){
        log.info("发送red消息"+msg);
        rabbitTemplate.convertAndSend("directExchange","queue.red",msg);
    }

    public void send02(Object msg){
        log.info("发送green消息"+msg);
        rabbitTemplate.convertAndSend("directExchange","queue.green",msg);
    }

    public void send03(Object msg){
        log.info("发送（queue_topic01）消息："+msg);
        rabbitTemplate.convertAndSend("topicExchange","queue.red.message",msg);
    }
    public void send04(Object msg){
        log.info("发送（被两个queue接收）消息："+msg);
        rabbitTemplate.convertAndSend("topicExchange","message.queue.green.message",msg);
    }
}

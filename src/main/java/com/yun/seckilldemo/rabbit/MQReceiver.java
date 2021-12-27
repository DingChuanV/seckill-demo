package com.yun.seckilldemo.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

/**
 * @author wanglufei
 * 消息接受者
 * @title: MQReceiver
 * @projectName seckill-demo
 * @description: TODO
 * @date 2021/11/8/3:33 下午
 */
@Service
@Slf4j
public class MQReceiver {
    @RabbitListener(queues = "queue")
    public void receive(Object msg) {
        log.info("接受消息" + msg);
    }
    @RabbitListener(queues = "queue_fanout01")
    public void receive01(Object msg){
        log.info("queue01接受消息："+msg);
    }
    @RabbitListener(queues = "queue_fanout02")
    public void receive02(Object msg){
        log.info("queue02接受消息："+msg);
    }

    @RabbitListener(queues = "queue_direct01")
    public void receive03(Object msg){
        log.info("queue_direct01接受消息："+msg);
    }

    @RabbitListener(queues = "queue_direct02")
    public void receive04(Object msg){
        log.info("queue_direct02接受消息："+msg);
    }

    @RabbitListener(queues = "queue_topic01")
    public void receive05(Object msg){
        log.info("QUEUE01_topic接收消息："+msg);
    }

    @RabbitListener(queues = "queue_topic01")
    public void receive06(Object msg){
        log.info("QUEUE02_topic接收消息："+msg);
    }
}

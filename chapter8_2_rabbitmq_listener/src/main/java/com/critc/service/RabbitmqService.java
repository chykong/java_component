package com.critc.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

/**
 * Created by 孔垂云 on 2017/12/3.
 */
@Service
public class RabbitmqService implements MessageListener {
    public void onMessage(Message message) {
        try {
            String msg = new String(message.getBody(), "utf-8");
            System.out.println("消息消费者 = " + msg);
        } catch (Exception e) {
        }
    }
}

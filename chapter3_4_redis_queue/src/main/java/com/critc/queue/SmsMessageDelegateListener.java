package com.critc.queue;

import java.io.Serializable;

/**
 * 消息队列监听
 *
 * @author chykong
 */
public class SmsMessageDelegateListener {

    // 监听Redis消息
    public void handleMessage(Serializable message) {
        System.out.println("收到消息" + message);
    }
}
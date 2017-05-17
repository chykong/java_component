package com.critc.queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 孔垂云 on 2017/5/18.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-redis.xml"})
public class TestSendMessage {

    @Autowired
    private SendMessage sendMessage;

    @Test
    public void testSendMessage() {
        SmsMessageVo smsMessageVo = new SmsMessageVo();
        smsMessageVo.setMobile("13811111111");
        smsMessageVo.setContent("1234");
        //一般消息内容会是一个json串，消费时再把json转成对象
        sendMessage.sendMessage("sms_queue_shortmessage", smsMessageVo.toString());
    }
}

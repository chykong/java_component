package com.critc.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 孔垂云 on 2017/5/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-redis.xml"})
public class TestStringRedisTemplate {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("name", "hello stringRedisTemplate");//设值
        System.out.println(stringRedisTemplate.opsForValue().get("name"));//取值
        stringRedisTemplate.delete("name");//删除
    }
}

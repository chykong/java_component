package com.critc.queue;

import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * 发送消息
 */
public class SendMessage {
	private RedisTemplate<String, Object> redisTemplate;

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void sendMessage(String channel, Serializable message) {
		redisTemplate.convertAndSend(channel, message);
	}
}

package com.critc.redis;

/**
 * Created by 孔垂云 on 2017/5/14.
 */
public class RedisUtil {
    /**
     * 设置值
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value) {
        JedisPoolUtil.getJedis().set(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
    }

    /**
     * 设置值,并设置保存时间
     *
     * @param key
     * @param value
     * @param secs 秒数
     */
    public static void set(String key, Object value, int secs) {
        JedisPoolUtil.getJedis().setex(SerializeUtil.serialize(key), secs, SerializeUtil.serialize(value));
    }

    /**
     * 根据key取值
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        return SerializeUtil.deserialize(JedisPoolUtil.getJedis().get(SerializeUtil.serialize(key)));
    }

    /**
     * 删除
     *
     * @param key
     */
    public static void del(String key) {
        JedisPoolUtil.getJedis().del(SerializeUtil.serialize(key));
    }

    public static void main(String[] args) {
        RedisUtil.set("com:critc:name", "jack");
        System.out.println(RedisUtil.get("com:critc:name").toString());
        RedisUtil.del("com:critc:name");
    }
}

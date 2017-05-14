package com.critc.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by 孔垂云 on 2017/5/6.
 */
public class GuavaCacheUtil {
    private static volatile GuavaCacheUtil guavaCacheUtil;
    public static volatile Cache cache;

    public static GuavaCacheUtil getInstance() {
        if (null == guavaCacheUtil) {
            synchronized (GuavaCacheUtil.class) {
                if (null == guavaCacheUtil) {
                    guavaCacheUtil = new GuavaCacheUtil();
                }
            }
        }
        return guavaCacheUtil;
    }

    static {
        try {
            //30分钟过期
            cache = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除key
     *
     * @param key
     */
    public static void remove(String key) {
        cache.invalidate(key);
    }

    /**
     * 根据key取值
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        return cache.getIfPresent(key);
    }

    /**
     * 赋值
     *
     * @param key
     * @param value
     */
    public static void put(String key, Object value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        GuavaCacheUtil.put("name", "jack");
        System.out.println(GuavaCacheUtil.get("name"));
    }
}

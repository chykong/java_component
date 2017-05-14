package com.critc.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by 孔垂云 on 2017/5/14.
 */
public class GuavaCacheTest {

    /**
     * LoadingCache方式建立
     */
    public void loadingCache() {
        LoadingCache<String, String> cacheBuilder = CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        String strProValue = "hello " + key + "!";
                        return strProValue;
                    }
                });
        try {
            System.out.println("jerry value:" + cacheBuilder.get("jerry"));
            System.out.println("peida value:" + cacheBuilder.get("peida"));
            cacheBuilder.put("harry", "ssdded");
            System.out.println("harry value:" + cacheBuilder.get("harry"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public void callableCache() {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String resultVal = null;
        try {
            resultVal = cache.get("jerry", new Callable<String>() {
                public String call() {
                    String strProValue = "hello " + "jerry" + "!";
                    return strProValue;
                }
            });
            System.out.println("jerry value : " + resultVal);
            resultVal = cache.get("peida", new Callable<String>() {
                public String call() {
                    String strProValue = "hello " + "peida" + "!";
                    return strProValue;
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("peida value : " + resultVal);
    }

    public static void main(String[] args) {
//        new GuavaCacheTest().loadingCache();
        new GuavaCacheTest().callableCache();

    }
}

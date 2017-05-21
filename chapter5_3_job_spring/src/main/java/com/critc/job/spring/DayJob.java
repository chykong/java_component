package com.critc.job.spring;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by 孔垂云 on 2017/5/21.
 * 基于Spring的定时任务
 */
@Component
@Lazy(false)
public class DayJob {
    /**
     *
     * 功能描述:每5秒钟执行一次
     *  void
     * @version 1.0.0
     * @author 孔垂云
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void executeJob() {
        System.out.println("Spring-task正在执行："+new Date());
    }

}

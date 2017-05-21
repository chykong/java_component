package com.critc.job.timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;
import java.util.Timer;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class JobListerner implements ServletContextListener {
    private java.util.Timer timer = null;
    private final static long DELAY_HOUR = 5 * 1000;//每5秒操作一次

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        timer.cancel();
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        timer = new Timer(true);
        timer.scheduleAtFixedRate(new JobTask(), new Date(), DELAY_HOUR);// 定时5秒钟处理一次
    }
}

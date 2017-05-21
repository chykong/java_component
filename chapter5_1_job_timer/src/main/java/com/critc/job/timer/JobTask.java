package com.critc.job.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class JobTask extends TimerTask {

    protected JobTask() {
        super();
    }

    public void run() {
        System.out.println("正在执行：" + new Date());
    }
}
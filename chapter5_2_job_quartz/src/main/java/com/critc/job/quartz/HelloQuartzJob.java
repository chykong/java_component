package com.critc.job.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class HelloQuartzJob implements Job {

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Hello, Quartz! - executing its JOB at " + new Date());
    }
}

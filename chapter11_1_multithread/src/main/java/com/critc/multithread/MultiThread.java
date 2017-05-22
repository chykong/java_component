package com.critc.multithread;

/**
 * Created by 孔垂云 on 2017/5/22.
 */
public class MultiThread implements Runnable {
    DealResource dealResource;// 定义车票资源

    public MultiThread(DealResource dealResource) {
        this.dealResource = dealResource;
    }

    public final void run() {
        while (!dealResource.flag) {
            /** * 调用资源类的同步方法 */
            dealResource.doIni(this);
        }
    }
}

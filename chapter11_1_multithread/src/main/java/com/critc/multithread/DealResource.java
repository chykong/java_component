package com.critc.multithread;

import java.util.List;

/**
 * Created by 孔垂云 on 2017/5/22.
 */
public class DealResource {
    private int ticketCount;//定义车票张数
    boolean flag = false; // 定义车票是否处理完
    List<String> listTickets;// 定义所有车票
    private static Object lock = new Object();// 定义锁，分配数据时不同步，处理数据时同步

    public DealResource(int ticketCount,List<String> listTickets) {
        this.ticketCount = ticketCount;
        this.listTickets = listTickets;
    }

    /**
     * synchronized线程安全
     */
    public void doIni(MultiThread multiThread) {
        String ticket = null;//定义该线程要处理的车票
        synchronized (lock) {
            if (ticketCount > 0) {
                ticket = listTickets.get(ticketCount - 1);
                ticketCount--;
            } else {
                flag = true;
            }
        }

        if (ticket != null) {
            if (!flag) {
                System.out.println("已卖" + ticket);
            }
        }
    }
}

package com.critc.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by 孔垂云 on 2017/5/22.
 */
public class TestMultiThread {

    /**
     * 生产车票
     *
     * @return
     */
    public List<String> createTickets() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("车票" + i);
        }
        return list;
    }

    public void sellTicket() {
        List<String> listTicket = createTickets();
        DealResource dealResource = new DealResource(listTicket.size(), listTicket);
        Vector<Thread> threads = new Vector<Thread>();
        int threadNum = 10;// 定义线程数量
        for (int i = 0; i < threadNum; i++) {
            Thread iThread = new Thread(new MultiThread(dealResource));
            threads.add(iThread);
            iThread.start();
        }

        for (Thread iThread : threads) {
            try {
                // 等待所有线程执行完毕
                iThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestMultiThread testMultiThread = new TestMultiThread();
        testMultiThread.sellTicket();
    }
}

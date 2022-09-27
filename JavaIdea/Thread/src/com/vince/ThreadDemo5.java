package com.vince;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        //4中方式
        //创建一个单线程线程池
        //ExecutorService es = Executors.newSingleThreadExecutor();
        //创建一个固定大小的线程池
        //ExecutorService es = Executors.newFixedThreadPool(2);
        //大小没有限制的
        //ExecutorService es = Executors.newCachedThreadPool();
        ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
        es.execute(new MyRunnable6());
        es.execute(new MyRunnable6());
        es.schedule(new MyRunnable6(), 3000, TimeUnit.MILLISECONDS);
        es.shutdown();
        //es.execute(new MyRunnable6());
    }
}

class MyRunnable6 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

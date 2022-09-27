package com.vince;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo4 {
    public static void main(String[] args) {
        MyRunnable5 mr5 = new MyRunnable5();
        Thread t1 = new Thread(mr5);
        Thread t2 = new Thread(mr5);
        t1.start();
        t2.start();
    }
}

class MyRunnable5 implements Runnable {
    private int ticket = 10;
    //private final Object obj = new Object();//同步锁

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
//            synchronized(this) {
//                if (ticket > 0) {
//                        ticket--;
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                        System.out.println("您购买的票剩于" + ticket + "张");
//                } else {
//                    break;
//                }
//            }
            method2();
        }
    }

    //同步方法:同步对象为当前对象
    private synchronized void method() {
        if (ticket > 0) {
            ticket--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("您购买的票剩于" + ticket + "张");
        }
    }

    ReentrantLock lock = new ReentrantLock();

    private void method2() {
        lock.lock();
        try {
            if (ticket > 0) {
                ticket--;
                Thread.sleep(1000);
                System.out.println("您购买的票剩于" + ticket + "张");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

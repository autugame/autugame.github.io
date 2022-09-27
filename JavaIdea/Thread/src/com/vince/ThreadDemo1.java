package com.vince;

/**
 * 线程的休眠
 * 静态方法在当前线程的执行中暂停指定的毫秒数，释放cpu的时间片
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        MyRunnable mr = new MyRunnable();
        Thread t2 = new Thread(mr);
        mt.start();//启动线程(真实是由虚拟机来作用的)
        t2.start();
    }
}

/**
 * 实现线程的第一种方式
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        super.run();
    }
}

/**
 * 实现线程的第二种方式实现Runnable
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package com.vince;

public class ThreadDemo3 {
    public static void main(String[] args) {
        MyRunnable4 mr4 = new MyRunnable4();
        Thread t = new Thread(mr4);
        //线程可以分为守护线程和用户线程
        t.setDaemon(true);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("main--" + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 5) {
                Thread.yield();
            }
        }
    }
}

class MyRunnable4 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("--" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

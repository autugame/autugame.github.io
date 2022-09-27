package com.vince;

/**
 * join方法:
 * 加入线程先执行指定时间在执行
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
//        MyRunnable2 mr = new MyRunnable2();
//        Thread t = new Thread(mr);
//        t.start();

        MyRunnable3 mr3 = new MyRunnable3();
        Thread t2 = new Thread(mr3);
        t2.start();

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 20) {
//                try {
//                    t.join(0);//让t线程执行完毕
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                //t.interrupt();//中断线程
                mr3.flag = false;
            }
        }
    }
}

//class MyRunnable2 implements Runnable {
//    @Override
//    public void run() {
//        for (int i = 0; i < 50; i++) {
//            System.out.println(Thread.currentThread().getName() + "--" + i);
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}

class MyRunnable3 implements Runnable {
    public boolean flag;

    public MyRunnable3() {
        flag = true;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "====" + (i++));
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}

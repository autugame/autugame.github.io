package com.vince;

public class ProducterCustomerDemo {
    public static void main(String[] args) {
        Food food = new Food();
        Producter p = new Producter(food);
        Customer c = new Customer(food);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}

class Customer implements Runnable {
    private final Food food;

    public Customer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            food.get();
        }
    }
}

/**
 * 生产者
 */
class Producter implements Runnable {
    private final Food food;

    public Producter(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                food.set("锅包肉", "酸甜口味");
            } else {
                food.set("佛跳墙", "狗屎口味");
            }
        }
    }
}

/**
 * 共享的食物对象
 */
class Food {
    private String name;
    private String desc;
    private boolean flag = true;//ture表示生产, false表示消费

    /**
     * 生产产品
     */
    public synchronized void set(String name, String desc) {
        //不能生产
        if (!flag) {
            try {
                this.wait();//线程进入等待状态释放对象锁
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.setName(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.setDesc(desc);
        flag = false;
        this.notify();
    }

    /**
     * 消费产品
     */
    public synchronized void get() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getName() + "->" + this.getDesc());
        flag = true;
        this.notify();
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Foot{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Food() {
        super();
    }
}

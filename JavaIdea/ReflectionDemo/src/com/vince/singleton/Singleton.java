package com.vince.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {
    private volatile static Singleton singleton = null;
    private Singleton() {
        if (singleton != null) {
            throw new RuntimeException("此类对象为单例模式,已经被创建了");
        }
    };

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}

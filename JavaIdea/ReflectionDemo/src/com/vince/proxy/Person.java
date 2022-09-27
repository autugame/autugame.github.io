package com.vince.proxy;

public class Person implements Subject, Hotel {
    @Override
    public void Shopping() {
        System.out.println("付款");
    }

    @Override
    public void reserve() {
        System.out.println("预定付款");
    }
}

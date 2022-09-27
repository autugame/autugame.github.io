package com.vince.aop;

import java.util.ArrayList;

public class IManagerImpl implements IManager {
    private ArrayList<String> list = new ArrayList<>();
    @Override
    public void add(String item) {
        //System.out.println("add start" + System.currentTimeMillis());
        list.add(item);
        System.out.println(item);
        //System.out.println("add end" + System.currentTimeMillis());
    }
}

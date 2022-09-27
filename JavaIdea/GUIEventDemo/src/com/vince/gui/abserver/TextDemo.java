package com.vince.gui.abserver;

public class TextDemo {
    public static void main(String[] args) {
        Message m = new Message();
        Observer o1 = new User("lily");
        Observer o2 = new User("tom");
        Observer o3 = new User("bin");
        m.registerObserver(o1);
        m.registerObserver(o2);
        m.registerObserver(o3);
        m.setMessage("你好");
        m.removeObserver(o1);
        m.setMessage("发红包");
    }
}

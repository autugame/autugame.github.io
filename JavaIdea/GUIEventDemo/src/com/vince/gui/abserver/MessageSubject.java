package com.vince.gui.abserver;


public interface MessageSubject {
    //ע��۲���
    public void registerObserver(Observer o);
    //�Ƴ��۲���
    public void removeObserver(Observer o);
    //֪ͨ���й۲���
    public void notifyObservers();
}

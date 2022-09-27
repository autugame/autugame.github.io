package com.vince.aop;

import org.junit.Test;

import java.io.InputStream;

public class AOPTest {
    @Test
    public void Test() {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/aop/bean.properties");
        BeanFactory beanFactory = new BeanFactory(in);
        ProsyFactoryBean bean = ((ProsyFactoryBean) beanFactory.getBean("bean"));
        IManager proxy = ((IManager) bean.getProxy());
        proxy.add("我是一只猫");
    }
}

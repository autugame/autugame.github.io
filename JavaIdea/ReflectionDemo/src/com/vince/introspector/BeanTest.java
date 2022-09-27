package com.vince.introspector;

import org.junit.Test;

public class BeanTest {
//    public static void main(String[] args) {
//        Config bean = ((Config) BeanFactory.getBean("bean.name"));
//        System.out.println(bean);
//    }
    @Test
    public void getBeanTest() {
        Config bean = ((Config) BeanFactory.getBean("bean.name"));
        System.out.println(bean);
    }
}

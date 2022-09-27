package com.vince.bean;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanTest {

    @Test
    public void Test() {
        String name = "bin";
        String age = "18";
        String salary = "20000";
        Emp emp = new Emp();
        try {
            BeanUtils.setProperty(emp, "name", name);
            BeanUtils.setProperty(emp, "age", age);
            BeanUtils.setProperty(emp, "salary", salary);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println(emp.getInfo());
    }
}

package com.vince;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AnnotationDemo {

    @Test
    public void test2() {
        Class<Cat> catClass = Cat.class;
        MyAnnotation annotation = catClass.getAnnotation(MyAnnotation.class);
        String name = annotation.name();
        int age = annotation.age();
        Color color = annotation.color();
        String[] like = annotation.like();
        try {
            Cat cat = catClass.newInstance();
            cat.setAge(age);
            cat.setName(name);
            cat.setLike(like);
            cat.setColor(color);
            System.out.println(cat);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test() {
        Cat cat = new Cat("miaomiao", 3);
        System.out.println(cat.printInfo());

        List list = new ArrayList();
        list.add("vince");
        list.add(10);
        list.add(10.1f);
    }
}

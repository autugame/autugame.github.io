package com.vince;

import org.junit.Test;

import java.lang.reflect.*;

public class ReflectionDemo {

    @Test
    public void Test5() {
        Dog dog = new Dog("wangwang", 4, "while");
        Class<Dog> dogClass = Dog.class;
        Package aPackage = dogClass.getPackage();
        System.out.println(aPackage.getName());
        Method[] methods = dogClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
            if (methods[i].getName().equals("toString")) {
                try {
                    String s = ((String) methods[i].invoke(dog));
                    System.out.println(s);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i]);
        }
    }

    @Test
    public void Test4() {
        Class<Dog> dogClass = Dog.class;
        Field[] fields = dogClass.getFields();
        //System.out.println(fields.length);
        Field[] declaredFields = dogClass.getDeclaredFields();
        //System.out.println(declaredFields.length);
        for (int i = 0; i < declaredFields.length; i++) {
            int modifiers = declaredFields[i].getModifiers();
            System.out.println(Modifier.toString(modifiers) + " " + declaredFields[i].getType() + " " + declaredFields[i].getName());
            System.out.println(declaredFields[i].getDeclaringClass().getPackage());
        }
    }

    @Test
    public void Test3() {
        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] constructors = dogClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
            System.out.println(constructors[i].getParameterCount());
        }
        try {
            Constructor<Dog> constructor = dogClass.getConstructor(String.class, int.class, String.class);
            //调用带参构造器
            Dog dog = constructor.newInstance("小白", 5, "break");
            System.out.println(dog);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void Test2() {
        Class<Dog> dogClass = Dog.class;
        try {
            Dog dog = dogClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 获取class对象的三种形式
     */
    @Test
    public void Test1() {
        //通过对象的getclass方法
        Dog dog = new Dog("wangwang", 4, "while");
        Class aClass = dog.getClass();

        Class dogClass = Dog.class;
        try {
            Class aClass1 = Class.forName("com.vince.Dog");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

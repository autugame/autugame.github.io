package com.vince;

import org.junit.Test;

import java.util.*;

public class GenericDemo {

    @Test
    public void test5() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "vince");
        map.put(2, "tom");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry a : entries) {
            System.out.println(a.getKey() + " " + a.getValue());
        }
    }

    @Test
    public void test4() {
        String[] arrays = {"vince", "jeck", "tom", "lily"};
        String[] strs = func(arrays, 0, 2);
        System.out.println(Arrays.toString(strs));
    }

    @Test
    public void test3() {
        Node<Number> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
//        getData(n1);
//        getData(n2);
        getUpperNumberData(n1);
        getUpperNumberData(n2);

    }

    public static <T> T[] func(T[] array, int i, int t) {
        T temp = array[i];
        array[i] = array[t];
        array[t] = temp;
        return array;
    }

    public static void getUpperNumberData(Node<? extends Number> data) {
        System.out.println(data.getData());
    }

    public static void getData(Node<?> node) {
        System.out.println(node.getData());
    }

    @Test
    public void test2() {
        Node<String> stringNode = new Node<>("vince");
        System.out.println(stringNode.getData());
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("你好");
//        list.add(10);
//        list.add(new Object());
        for (int i = 0; i < list.size(); i++) {

        }
    }
}

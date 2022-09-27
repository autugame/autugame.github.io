package com.vince;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

public class EnumDemo {
    public static final int RED = 0x1;
    public static final int GREEN = 0x2;
    public static final int BLUE = 0x3;
    public int color;
    @Test
    public void test1() {
        color = RED;
    }

    public Color colorEnum;

    @Test
    public void test2() {
        colorEnum = Color.RED;
        System.out.println(colorEnum);
        System.out.println(colorEnum.name());
        System.out.println(colorEnum.ordinal());

        Color[] values = Color.values();
        System.out.println("Arrays.toString() = " + Arrays.toString(values));
    }

    @Test
    public void test3() {
        EnumSet<Color> set = EnumSet.allOf(Color.class);
        for (Color c : set) {
            System.out.println(c);
        }
        EnumMap<Color, String> map = new EnumMap<>(Color.class);
        map.put(Color.RED, "red");
        map.put(Color.GREEN, "green");
        map.put(Color.BLUE, "blue");
    }

    @Test
    public void test4() {
        System.out.println(Color.RED.getColor());
        System.out.println(Color.RED.getColor2());
    }

    @Test
    public void test5() {
        Singleton.singleton.method();
    }
}

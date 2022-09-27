package com.autuo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
	
	private static void treeMap() {
		//Map<String, String> map = new TreeMap<>();
		//map.put("one", "小黑子");
		//map.put("two", "ikun");
		//map.put("three", "坤坤");
		
		//map.forEach((key, value) -> System.out.println(key + "->" + value));
		Map<Dog, String> dogs = new TreeMap<>();
		dogs.put(new Dog(1, "dog", 5), "dog1");
		dogs.put(new Dog(2, "olddog", 5), "dog2");
		dogs.put(new Dog(3, "newdog", 5), "dog3");
		dogs.forEach((key, value) -> System.out.println(key + value));
	}
	
	private static void linkedHashMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("one", "小黑子");
		map.put("two", "ikun");
		map.put("three", "坤坤");
		
		map.forEach((key, value) -> System.out.println(key + "->" + value));
	}
	
	private static void hashtable() {
		Map<String, String> table = new Hashtable<>();
		table.put("one", "小黑子");
		table.put("two", "ikun");
		table.put("three", "坤坤");
		
		table.forEach((key, value) -> System.out.println(key + "->" + value));
	}
	
	private static void hashMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "小张");
		map.put(2, "小李");
		map.put(3, "小王");
		map.put(4, "小刘");
		map.put(5, "小坤");
		
		System.out.println(map.size());
		//从里面取值
		System.out.println(map.get(1));//典型的通过key取值
		
		//map的遍历
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		entrySet.forEach(System.out::println);
		for (Entry e : entrySet) {
			System.out.println(e.getKey() + "->" + e.getValue());
		}
		Set<Integer> keys = map.keySet();
		for (Integer i : keys) {
			System.out.println(i + "-->" + map.get(i));
		}
		
		Collection<String> values = map.values();
		for (String value : values) {
			System.out.println(value);
		}
	}
	
	public static void main(String[] args) {
		//hashMap();
		//hashtable();
		//linkedHashMap();
		treeMap();
	}

}

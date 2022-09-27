package com.autuo;

public class Cat implements Comparable<Cat> {
	private String name;
	private int age;

	public Cat() {
		super();
	}

	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Cat o) {
//		if (this.age < o.age)
//			return -1;
//		if (this.age > o.age)
//			return 1;
		return this.age - o.age;
	}

}

package com.autuo;

public class Dog implements Comparable<Dog> {
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dog(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Dog o) {
		// TODO Auto-generated method stub
		return this.id - o.id;
	}
	
}

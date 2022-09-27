package com.autuo;

import java.util.HashSet;

public class Teacher {
	private String name;
	private int age;
	private String sex;
	private HashSet<Student> students = new HashSet<>();
	
	
	
	public HashSet<Student> getStudents() {
		return students;
	}
	public void setStudents(HashSet<Student> students) {
		this.students = students;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Teacher(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}

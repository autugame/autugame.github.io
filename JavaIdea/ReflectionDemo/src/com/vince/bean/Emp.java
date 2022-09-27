package com.vince.bean;

public class Emp {
    private String name;
    private int age;
    private int salary;

    public String getInfo() {
        return "name=" + name + "-age=" + age + "-salary=" + salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

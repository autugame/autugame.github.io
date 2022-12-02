package com.qf.person;

public class TestRegister {
    public static void main(String[] args) {
        PersonServiceImpl personService = new PersonServiceImpl();
        Person person = new Person("zom", 12, DateUtils.strToUtil("1998-09-08"), "zom@163.com", "北京市");
        personService.register(person);
    }
}

package com.qf.person;

public class TestPersonSelect {
    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = personDao.select(4);
        System.out.println(person);
    }
}

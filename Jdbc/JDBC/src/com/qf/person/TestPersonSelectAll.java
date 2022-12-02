package com.qf.person;

import java.util.List;

public class TestPersonSelectAll {
    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        List<Person> list = personDao.selectAll();
        for (Person p : list) {
            System.out.println(p);
        }
    }
}

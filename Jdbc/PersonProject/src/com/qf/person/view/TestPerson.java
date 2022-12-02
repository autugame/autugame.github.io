package com.qf.person.view;

import com.qf.person.dao.impl.PersonDaoImpl;
import com.qf.person.dao.PersonDao;
import com.qf.person.entiry.Person;
import com.qf.person.utils.DateUtils;

import java.util.List;

public class TestPerson {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDaoImpl();
//        Person person = new Person(13,"Gavin", 19, DateUtils.strToUtil("1998-09-09"), "Gavin@163.com", "北京市昌平区");
//        //int result = personDao.insert(person);
//        //int result = personDao.update(person);
//        int result = personDao.delete(13);
//        System.out.println(result);
        List<Person> list = personDao.selectAll();
        for (Person p : list) {
            System.out.println(p);
        }
    }
}

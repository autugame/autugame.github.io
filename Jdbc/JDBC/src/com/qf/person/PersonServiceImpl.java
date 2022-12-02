package com.qf.person;

public class PersonServiceImpl {
    //1,注册
    public void register(Person person) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        //1,查询用户是否存在
        Person persons = personDao.select(person.getName());
        //2,不存在，新增
        if (persons == null) {
            personDao.insert(person);
            System.out.println("注册成功");
        } else {
            //3,已存在返回，已注册
            System.out.println("该用户已存在");
        }
    }
}

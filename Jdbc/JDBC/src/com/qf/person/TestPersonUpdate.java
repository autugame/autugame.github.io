package com.qf.person;

public class TestPersonUpdate {
    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = new Person("Aaron", 20, DateUtils.strToUtil("2000-03-08"), "Aaron@vip.com", "北京市昌平区");
        person.setId(6);
        int result = personDao.update(person);
        if (result == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }
}

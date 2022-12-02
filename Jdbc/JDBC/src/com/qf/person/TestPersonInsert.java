package com.qf.person;

public class TestPersonInsert {
    public static void main(String[] args) {
        //测试新增
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = new Person("wangming", 19, DateUtils.strToUtil("2005-03-12"), "wangming@163.com", "北京市海淀区");
        int result = personDao.insert(person);
        if (result == 1) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败！");
        }
    }
}

package com.qf.person;

public class TestPersonDelete {
    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        int result = personDao.delete(2);
        if (result == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}

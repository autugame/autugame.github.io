package com.qf.finals.test;

import com.qf.finals.dao.impl.UserDaoImpl;
import com.qf.finals.entity.User;

import java.util.List;

public class TestDbutils {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User(3, "Aaron", "1234", "12345678910");
        //int result = userDao.insert(user);
//        int result = userDao.delete(3);
//        System.out.println(result);
//        List<User> users = userDao.selectAll();
//        for (User u : users) {
//            System.out.println(u);
//        }
        long count = userDao.selectUserNum();
        System.out.println(count);
    }
}

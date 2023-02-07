package com.qfedu.jdbc.les1;

import com.qfedu.jdbc.dao.UserDAO;
import com.qfedu.jdbc.dto.User;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;

public class TestInsertUser {
    public static void main(String[] args) {
        String username = "xiaowei";
        String password = "123456789";
        String phone = "11122223213";
        User user = new User(0, username, password, phone);
        try {
            boolean flag = new UserDAO().insertUser(user);
            if (flag) {
                System.out.println("数据表添加成功");
            } else {
                System.out.println("数据表添加失败");
            }
        } catch (SQLException e) {
            System.err.println("出现异常");
        }
    }


}

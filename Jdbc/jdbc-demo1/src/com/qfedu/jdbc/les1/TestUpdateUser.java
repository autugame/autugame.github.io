package com.qfedu.jdbc.les1;

import com.qfedu.jdbc.dao.UserDAO;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;

public class TestUpdateUser {
    public static void main(String[] args) throws Exception {
        int id = 8;
        String username = "tian";
        String password = "1314";
        String phone = "11125880883";
        System.out.println(new UserDAO().updateUser(id, username, password, phone) ? "修改成功" : "修改失败");
    }


}

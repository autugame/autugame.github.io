package com.qfedu.jdbc.les1;

import com.qfedu.jdbc.dao.UserDAO;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TestDeleteUser {
    public static void main(String[] args) throws Exception {
        int id = 5;
        boolean b = new UserDAO().deleteUser(id);
        System.out.println(b ? "删除成功" : "删除失败");
    }


}

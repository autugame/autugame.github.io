package com.qf.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginJdbc {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String userName = input.next();
        System.out.println("请输入密码");
        String password = input.next();

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_company", "root", "");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from user where username='" + userName + "' and password='" + password +"'");

        if (resultSet.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登录失败");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}

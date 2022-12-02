package com.qf.JDBC;

import java.sql.*;
import java.util.Scanner;

public class LoginJdbc2 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String userName = input.next();
        System.out.println("请输入密码");
        String password = input.next();

        Connection connection = DBUtils.getConnection();

        //获得preparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username=? and password=?;");

        //为占位符赋值
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败，请检查密码或账户");
        }

        DBUtils.closeAll(connection, preparedStatement, resultSet);
    }
}

package com.qf.JDBC;

import java.sql.*;

/**
 * 重用性方案
 * 获取连接
 * 释放资源
 */
public class DBUtils {
    //类加载执行一次
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //1，获取连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_company", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    //2，释放资源
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

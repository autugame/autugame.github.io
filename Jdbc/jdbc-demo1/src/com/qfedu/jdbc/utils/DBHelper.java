package com.qfedu.jdbc.utils;

import java.sql.*;

public class DBHelper {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_company?characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "A3452896431@a";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("----------注册驱动失败");
        }
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("----------创建连接失败");
        }
        return connection;
    }

    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("关闭数据库连接失败");
        }
    }
}

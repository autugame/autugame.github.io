package com.qfedu.jdbc.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {
    //1,定义数据库连接信息
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_test?characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "A3452896431@a";

    private static final ThreadLocal<Connection> local = new ThreadLocal<>();

    //2,静态初始化块注册驱动
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //3,创建数据库连接
    public static Connection getConnection() {
        //从容器中获取连接
        Connection connection = local.get();
        try {
            if (connection == null) {
                //如果容器中没有连接，则创建连接
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                //将创建的连接存放到容器中
                local.set(connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    ///4,关闭连接
    public static void close() {
        Connection connection = local.get();//获取当前线程使用的数据库连接对象
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            //将关闭后的对象从Thread local中移除
            local.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Statement statement) {
        close(null, statement);
    }
    public static void close(ResultSet resultSet, Statement statement) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

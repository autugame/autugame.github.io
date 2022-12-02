package com.qf.person.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 连接数据库
 * 事务的控制
 * 释放资源
 */
public class DBUtils {
    private static final Properties PROPERTIES = new Properties();
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();

    static {
        InputStream is = DBUtils.class.getResourceAsStream("/db.properties");
        try {
            PROPERTIES.load(is);
            Class.forName(PROPERTIES.getProperty("driver"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        Connection connection = THREAD_LOCAL.get();
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(PROPERTIES.getProperty("url"), PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
                THREAD_LOCAL.set(connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    //开启事务
    public static void begin() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //提交事务
    public static void commit() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //回滚事务
    public static void rollback() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
                THREAD_LOCAL.remove();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
package com.qf.account;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static final Properties PROPERTIES = new Properties();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
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
        Connection connection = threadLocal.get();//将当前线程中绑定的connection对象赋值
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(PROPERTIES.getProperty("url"), PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
                threadLocal.set(connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void begin() {
        try {
            Connection connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll(connection, null, null);
        }
    }

    public static void rollback() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll(connection, null, null);
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
                threadLocal.remove();//关闭连接后移除已关闭connection对象
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

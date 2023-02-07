package com.qfedu.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid数据库连接池的工具类
 */
public class DruidUtils {
    //druidDataSource对象就表示数据库对象连接池(数据源)
    private static DruidDataSource druidDataSource;
    //静态代码块初始化druidDataSource对象
    static {
        try {
            //读取druid.properties文件中配置的属性
            InputStream is = DruidUtils.class.getResourceAsStream("/druid.properties");
            Properties properties = new Properties();
            properties.load(is);
            //使用属性文件初始化DruidDataSource对象
            druidDataSource = ((DruidDataSource) DruidDataSourceFactory.createDataSource(properties));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //创建静态方法从连接池中获取连接
    public static Connection getConnection() {
        try {
            return druidDataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet resultSet, Statement statement) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

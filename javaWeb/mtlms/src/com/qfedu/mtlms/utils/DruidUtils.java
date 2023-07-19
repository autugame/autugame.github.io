package com.qfedu.mtlms.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Database connection pool tool class.
 */
public class DruidUtils {
    //定义Druid数据库连接池数据源
    private static final DruidDataSource DRUID_DATA_SOURCE;

    /**
     * Initializes the Database connection pool.
     */
    static {
        try {
            InputStream is = DruidUtils.class.getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(is);
            DRUID_DATA_SOURCE = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the connection pool data source.
     * @return DataSource object
     */
    public static DataSource getDataSource(){
        return DRUID_DATA_SOURCE;
    }
    
    /**
     * Gets the database connection from the connection pool.
     * Usually you don't have to.
     * @return DataBase connection
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DRUID_DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

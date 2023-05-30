package com.qfedu.sgms.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {
    private static final DruidDataSource DRUID_DATA_SOURCE;

    static {
        try {
            InputStream is = DruidUtils.class.getResourceAsStream("./druid.properties");
            Properties properties = new Properties();
            properties.load(is);

            DRUID_DATA_SOURCE = ((DruidDataSource) DruidDataSourceFactory.createDataSource(properties));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //获取数据连接池连接源
    public static DataSource getDataSource() {
        return DRUID_DATA_SOURCE;
    }

    //从数据库连接池中获取数据库连接对象
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DRUID_DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

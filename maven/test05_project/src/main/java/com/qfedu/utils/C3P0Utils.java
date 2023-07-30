package com.qfedu.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Utils {
    //1.Define a member variable.
    private static final DataSource DATA_SOURCE = new ComboPooledDataSource();

    //2.Return data source.

    public static DataSource getDataSource() {
        return DATA_SOURCE;
    }
    //3.Provide a connection object.
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}

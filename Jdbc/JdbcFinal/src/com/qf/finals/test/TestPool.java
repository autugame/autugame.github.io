package com.qf.finals.test;

import com.qf.finals.utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestPool {
    public static void main(String[] args) throws SQLException {
        for (int i = 1; i <= 20; i++) {
            Connection connection = DBUtils.getConnection();
            System.out.println(connection);
            connection.close();
        }
    }
}

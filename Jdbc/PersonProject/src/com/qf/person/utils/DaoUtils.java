package com.qf.person.utils;

import com.qf.person.advanced.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 复用 增删改查方法
 */
public class DaoUtils<T> {
    /**
     * 公共处理增删改的方法
     *
     * @param sql  要执行的sql语句
     * @param args 可变长参数列表
     * @return 受影响行数
     */
    public int commonsUpdate(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.closeAll(null, preparedStatement, null);
        }
    }

    public List<T> commonsSelect(String sql, RowMapper<T> rowMapper, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                T t = rowMapper.getRow(resultSet);
                list.add(t);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

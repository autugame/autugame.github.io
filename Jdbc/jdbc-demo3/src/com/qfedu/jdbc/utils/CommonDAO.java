package com.qfedu.jdbc.utils;

import com.qfedu.jdbc.dto.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于封装公共的jdbc操作
 */
public class CommonDAO<T> {
    /**
     * 公共dml操作
     * @param sql
     * @return 返回结果true：false
     */
    public boolean update(String sql, Object... args) {
        boolean b = false;
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = DruidUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1, args[i]);
            }
            int i = preparedStatement.executeUpdate();
            b = i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(null, preparedStatement);
        }
        return b;
    }

    public List<T> select(String sql, RowMapper<T> rowMapper, Object... args) {
        List<T> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Connection connection = DruidUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //从查询结果中取出一行记录
                T t = rowMapper.getRow(resultSet);
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(resultSet, preparedStatement);
        }
        return list;
    }
}

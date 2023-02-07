package com.qfedu.jdbc.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用于定义结果集映射
 */
public interface RowMapper<T> {
    public T getRow(ResultSet resultSet) throws SQLException;
}

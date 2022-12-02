package com.qf.person.advanced;

import java.sql.ResultSet;

/**
 * 约束封装对象的orm
 */
public interface RowMapper<T> {
    public T getRow(ResultSet resultSet);
}

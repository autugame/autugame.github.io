package com.qfedu.dao;

import com.qfedu.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    /**
     * Query all user information.
     */
    public List<User> findUsers() throws SQLException;
}

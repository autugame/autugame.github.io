package com.qfedu.service;

import com.qfedu.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public List<User> queryUsers() throws SQLException;
}

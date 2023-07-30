package com.qfedu.service;

import com.qfedu.dao.UserDaoImpl;
import com.qfedu.pojo.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> queryUsers() throws SQLException {
        return new UserDaoImpl().findUsers();
    }
}

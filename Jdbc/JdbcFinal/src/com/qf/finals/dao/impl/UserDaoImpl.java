package com.qf.finals.dao.impl;

import com.qf.finals.dao.UserDao;
import com.qf.finals.entity.User;
import com.qf.finals.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
    @Override
    public int insert(User user) {
        Object[] params = {user.getId(), user.getUsername(), user.getPassword(), user.getPhone()};
        try {
            int result = queryRunner.update("insert into user(id,username,password,phone) values(?,?,?,?);", params);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(User user) {
        Object[] params = {user.getUsername(), user.getPassword(), user.getPhone(), user.getId(),};
        try {
            int result = queryRunner.update("update user set username=?,password=?,phone=? where id=?", params);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        try {
            int result = queryRunner.update("delete from user where id=?", id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User select(int id) {
        try {
            User user = queryRunner.query("select * from user where id=?", new BeanHandler<User>(User.class), id);
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long selectUserNum() {
        try {
            long count = queryRunner.query("select count(*) from user", new ScalarHandler<>());
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> selectAll() {
        try {
            List<User> userList = queryRunner.query("select * from user", new BeanListHandler<User>(User.class));
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

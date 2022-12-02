package com.qf.finals.dao;

import com.qf.finals.entity.User;

import java.util.List;

public interface UserDao {
    public int insert(User user);
    public int update(User user);
    public int delete(int id);
    public User select(int id);
    public List<User> selectAll();
    public long selectUserNum();
}

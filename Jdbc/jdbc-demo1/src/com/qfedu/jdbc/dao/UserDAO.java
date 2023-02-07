package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.dto.User;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet rs;
    public boolean deleteUser(int id) {
        boolean flag = false;
        try {
            connection = DBHelper.getConnection();
            //3,编写sql
            String sql = "delete from user where id=?;";
            //4,获取sql加载器
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            //5,执行sql
            int i = preparedStatement.executeUpdate();
            flag = i > 0;
            //7,关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(preparedStatement, connection);
        }
        return flag;
    }

    public boolean insertUser(User user) throws SQLException {
        boolean flag = false;
        try {
            connection = DBHelper.getConnection();
            String sql = "insert into user(username,password,phone) values(?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhone());
            int i = preparedStatement.executeUpdate();
            flag = i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(preparedStatement, connection);
        }
        return flag;
    }

    public User queryUser(int id) throws SQLException {
        User user = null;
        try {
            connection = DBHelper.getConnection();
            String sql = "select id,username,password,phone from user where id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int uid = rs.getInt("id");
                String name = rs.getString("username");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                user = new User(uid, name, password, phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs, preparedStatement, connection);
        }
        return user;
    }

    public List<User> listUser() throws SQLException {
        List<User> list = new ArrayList<>();
        try {
            connection = DBHelper.getConnection();
            String sql = "select id,username,password,phone from user;";
            statement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                list.add(new User(id, name, password, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs, statement, connection);
        }
        return list;
    }

    public boolean updateUser(int id, String username, String password, String phone) throws Exception {
        boolean flag = false;
        try {
            connection = DBHelper.getConnection();
            String sql = "update user set username=?,password=?,phone=? where id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, phone);
            preparedStatement.setInt(4, id);
            int i = preparedStatement.executeUpdate();
            flag = i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(preparedStatement, connection);
        }
        return flag;
    }
}

package com.qf.JDBC2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestORM {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from user");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                //创建对象
                User user = new User(id, username, password, phone);
                userList.add(user);
            }
            for (User u : userList) {
                System.out.println(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.closeAll(connection, preparedStatement, resultSet);
        }

    }
}

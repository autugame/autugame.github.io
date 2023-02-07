package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {
    public boolean updateStock(String bookId, int num) {
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBHelper.getConnection();
            String sql2 = "update books set book_stock = book_stock-? where book_id=?";preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, num);
            preparedStatement.setString(2, bookId);
            int i = preparedStatement.executeUpdate();
            flag = i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(preparedStatement);
        }
        return flag;
    }
}

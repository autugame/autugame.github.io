package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RecordDAO {
    public boolean insertRecord(String stuNum, String bookId, int num) {
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBHelper.getConnection();
            String sql1 = "insert into records(snum,bid,borrow_num,is_return,borrow_date) values(?,?,?,'0',sysdate());";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, stuNum);
            preparedStatement.setString(2, bookId);
            preparedStatement.setInt(3, num);
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

package com.qfedu.jdbc.service;

import com.qfedu.jdbc.dao.BookDAO;
import com.qfedu.jdbc.dao.RecordDAO;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;

public class BookService {
    private RecordDAO recordDAO = new RecordDAO();
    private BookDAO bookDAO = new BookDAO();
    public boolean borrowBook(String stuNum, String bookId, int num) {
        Connection connection = DBHelper.getConnection();
        boolean r = false;
        try {
            connection.setAutoCommit(false);
            //1, 添加借书记录
            boolean b1 = recordDAO.insertRecord(stuNum, bookId, num);
            //2, 修改图书库存
            boolean b2 = bookDAO.updateStock(bookId, num);
             r = b1 && b2;
             connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally {
            DBHelper.close();
        }
        return r;
    }
}

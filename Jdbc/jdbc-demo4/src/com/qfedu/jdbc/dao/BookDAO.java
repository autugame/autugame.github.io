package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.dto.Book;
import com.qfedu.jdbc.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 完成图书信息数据库操作类
 */
public class BookDAO {
    public int insertBook(Book book) {
        int i = 0;
        try {
            String sql = "insert into books(book_name,book_author,book_price,book_stock,book_desc) values(?,?,?,?,?);";
            Object[] params = {book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookStock(), book.getBookDesc()};
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public int deleteBook(int bookId) {
        int i = 0;
        try {
            String sql = "delete from books where book_id=?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, bookId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public int updateBook(Book book) {
        int i = 0;
        try {
            String sql = "update books set book_name=?,book_author=?,book_price=?,book_stock=?,book_desc=? where book_id=?";
            Object[] params = {book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookStock(), book.getBookDesc(), book.getBookId()};
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public Book queryBook(int bookId) {
        Book book = null;
        try {
            String sql = "select book_id as bookId,book_name as bookName,book_author as bookAuthor,book_price as bookPrice,book_stock as bookStock,book_desc as bookDesc from books where book_id=?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            book = queryRunner.query(sql, new BeanHandler<Book>(Book.class), bookId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    public List<Book> listBooks() {
        List<Book> bookList = new ArrayList<>();
        try {
            String sql = "select book_id as bookId,book_name as bookName,book_author as bookAuthor,book_price as bookPrice,book_stock as bookStock,book_desc as bookDesc from books";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            bookList = queryRunner.query(sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

    public long getCount() {
        long count = 0;
        try {
            String sql ="select count(1) from books;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
            count = queryRunner.query(sql, scalarHandler);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}

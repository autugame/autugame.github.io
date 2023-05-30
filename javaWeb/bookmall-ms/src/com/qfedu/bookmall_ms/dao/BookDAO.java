package com.qfedu.bookmall_ms.dao;

import com.qfedu.bookmall_ms.dto.Book;
import com.qfedu.bookmall_ms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class BookDAO {
    //添加图书信息
    public int insertBook(Book book){
        int i = 0;
        try {
            String sql = "insert into books(book_id,book_name,book_author,book_price,book_img_path,book_desc,book_stock,book_type) values(?,?,?,?,?,?,?,?);";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            Object[] params = {book.getBookId(), book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookImgPath(), book.getBookDesc(), book.getBookStock(), book.getBookType()};
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
    //分页查询图书信息
    public List<Book> selectBooks(int start, int limit){
        List<Book> bookList = null;
        try {
            String sql = "select book_id bookId,book_name bookName,book_author bookAuthor,book_price bookPrice,book_img_path bookImgPath,book_desc bookDesc,book_stock bookStock,book_type bookType from books " +
                    "limit ?,?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            bookList = queryRunner.query(sql, new BeanListHandler<Book>(Book.class), start, limit);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }
    //根据图书ID删除图书
    public int deleteBook(String bookId){
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
    //根据图书ID修改图书
    public int updateBook(Book book){
        int i = 0;
        try {
            String sql = "update books set book_name=?,book_author=?,book_price=?,book_img_path=?,book_desc=?,book_stock=?,book_type=? where book_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            Object[] params = {book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookImgPath(), book.getBookDesc(), book.getBookStock(), book.getBookType(), book.getBookId()};
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
    //查询图书总记录数
    public long selectBookCount(){
        long count = 0;
        try {
            String sql = "select count(1) from books";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            count = queryRunner.query(sql, new ScalarHandler<Long>());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    //根据图书ID查询图书
    public Book selectBookByBookId(String bookId){
        Book book = null;
        try {
            String sql = "select book_id bookId,book_name bookName,book_author bookAuthor,book_price bookPrice,book_img_path bookImgPath,book_desc bookDesc,book_stock bookStock,book_type bookType from books where book_id=?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            book = queryRunner.query(sql, new BeanHandler<Book>(Book.class), bookId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }
    @Test
    public void TestInsertBook(){
        Book book = new Book("100001", "30天自制操作系统", "川合秀实", 99.00, "files/00001.jpg", "30天自制操作系统", 1, 1);
        int i = insertBook(book);
        System.out.println(i);
    }

    @Test
    public void TestSelectBooks(){
        //System.out.println(selectBooks());
    }

    @Test
    public void TestUpdateBook(){
        Book book = new Book("100001", "30天自制操作系统", "川合秀实", 99.00, "files/00002.jpg", "30天自制操作系统", 1, 1);
        updateBook(book);
    }

    @Test
    public void TestSelectBooksByBookId(){
        System.out.println(selectBookByBookId("100001"));
    }
}

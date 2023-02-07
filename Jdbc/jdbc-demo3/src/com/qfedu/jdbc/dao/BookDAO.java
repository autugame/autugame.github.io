package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.dto.Book;
import com.qfedu.jdbc.utils.CommonDAO;
import com.qfedu.jdbc.utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDAO {
    private CommonDAO<Book> commonDAO = new CommonDAO<>();
    public boolean insertBook(Book book) {
        String sql = "insert into books(book_name,book_author,book_price,book_stock,book_desc) values(?,?,?,?,?);";
        boolean b = commonDAO.update(sql, book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookStock(), book.getBookDesc());
        return b;
    }

    public boolean deleteBook(int bookId) {
        String sql = "delete from books where id=?;";
        boolean b = commonDAO.update(sql, bookId);
        return b;
    }

    public boolean updateBook(Book book) {
        String sql = "update books set book_name=?,book_author=?,book_price=?,book_stock=?,book_desc=? where book_id=?;";
        boolean b = commonDAO.update(sql, book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookStock(), book.getBookDesc(), book.getBookId());
        return b;
    }

    public Book queryBook(int bookId) {
        String sql = "select book_id,book_name,book_author,book_price,book_stock,book_desc from books where book_id=?";
        RowMapper<Book> bookRowMapper = new RowMapper<Book>() {
            @Override
            public Book getRow(ResultSet resultSet) throws SQLException {
                int bookID = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                String bookAuthor = resultSet.getString("book_author");
                double bookPrice = resultSet.getDouble("book_price");
                int bookStock = resultSet.getInt("book_stock");
                String bookDesc = resultSet.getString("book_desc");
                return new Book(bookID, bookName, bookAuthor, bookPrice, bookStock, bookDesc);
            }
        };
        List<Book> list = commonDAO.select(sql, bookRowMapper ,bookId);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Book> listBooks() {
        String sql = "select book_id,book_name,book_author,book_price,book_stock,book_desc from books";
        List<Book> list = commonDAO.select(sql, resultSet -> {
            int bookID = resultSet.getInt("book_id");
            String bookName = resultSet.getString("book_name");
            String bookAuthor = resultSet.getString("book_author");
            double bookPrice = resultSet.getDouble("book_price");
            int bookStock = resultSet.getInt("book_stock");
            String bookDesc = resultSet.getString("book_desc");
            return new Book(bookID, bookName, bookAuthor, bookPrice, bookStock, bookDesc);
        });
        return list;
    }
}

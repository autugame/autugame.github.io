package com.qfedu.jsp.dao;

import com.qfedu.jsp.dto.Book;
import com.qfedu.jsp.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDAO {
    public List<Book> listBooks(){
        List<Book> bookList;
        try {
            String sql = "select " +
                    "book_id bookId,book_name bookName,book_author bookAuthor,book_price bookPrice,book_img_path bookImgPath,book_desc bookDesc,book_type bookType " +
                    "from books";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            bookList = queryRunner.query(sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }
}

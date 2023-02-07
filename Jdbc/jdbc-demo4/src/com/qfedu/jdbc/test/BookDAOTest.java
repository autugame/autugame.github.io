package com.qfedu.jdbc.test;

import com.qfedu.jdbc.dao.BookDAO;
import com.qfedu.jdbc.dto.Book;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookDAOTest {
    private BookDAO bookDAO = new BookDAO();
    @Test
    public void testInsertBook() {
        Book book = new Book(0, "c语言程序设计", "谭浩强", 66.80, 12, "鼻祖级教程");
        int i = bookDAO.insertBook(book);
        assertEquals(1, i);
    }

    @Test
    public void testDeleteBook() {
        int i = bookDAO.deleteBook(3);
        assertEquals(1, i);
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book(3, "java王者归来", "张某人", 99.99, 12, "学完就是大佬");
        int i = bookDAO.updateBook(book);
        assertEquals(1, i);
    }

    @Test
    public void testQueryBook() {
        Book book = bookDAO.queryBook(3);
        System.out.println(book);
    }

    @Test
    public void testListBooks() {
        List<Book> bookList = bookDAO.listBooks();
        for (Book b : bookList) {
            System.out.println(b);
        }
    }

    @Test
    public void testGetCount() {
        System.out.println(bookDAO.getCount());
    }
}

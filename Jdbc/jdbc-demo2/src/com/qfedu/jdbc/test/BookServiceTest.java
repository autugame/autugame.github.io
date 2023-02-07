package com.qfedu.jdbc.test;

import com.qfedu.jdbc.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookService bookService = new BookService();
    @Test
    public void textBorrowBook() {
        boolean b = bookService.borrowBook("0001", "1", 2);
        assertTrue(b);
    }

}
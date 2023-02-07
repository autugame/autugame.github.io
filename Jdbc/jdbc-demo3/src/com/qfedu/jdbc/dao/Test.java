package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.dto.Book;
import com.qfedu.jdbc.dto.Student;

import java.util.List;

public class Test {
    public static void main(String[] args) {
//        List<Student> list = new StudentDAO().listStudents();
//        System.out.println(list);
        //Book book = new Book(0, "大学语文", "王五", 22.80, 6, "清华大学出版社");
        Book book = new BookDAO().queryBook(2);
        System.out.println(book);
    }
}

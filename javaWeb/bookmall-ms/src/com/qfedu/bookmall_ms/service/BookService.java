package com.qfedu.bookmall_ms.service;

import com.qfedu.bookmall_ms.dao.BookDAO;
import com.qfedu.bookmall_ms.dto.Book;
import com.qfedu.bookmall_ms.utils.PageHelper;

import java.util.List;

public class BookService {
    private final BookDAO BOOKDAO = new BookDAO();
    //添加图书业务实现
    public boolean saveBook(Book book){
        int i = BOOKDAO.insertBook(book);
        return i>0 ? true : false;
    }
    //删除图书业务实现
    public boolean deleteBook(String bookId){
        int i = BOOKDAO.deleteBook(bookId);
        return i>0 ? true : false;
    }
    //根据ID查询一个图书业务实现
    public Book getBook(String bookId){
        Book book = BOOKDAO.selectBookByBookId(bookId);
        return book;
    }
    //修改图书业务实现
    public boolean modifyBook(Book book){
        int i = BOOKDAO.updateBook(book);
        return i>0 ? true : false;
    }
    //分页查询图书信息
    public PageHelper<Book> listBooksByPage(int pageNum, int pageSize){
        //查询当前页面数据
        int start = (pageNum-1)*pageSize;
        int limit = pageSize;
        List<Book> bookList = BOOKDAO.selectBooks(start, limit);
        //查询总记录数
        long count = BOOKDAO.selectBookCount();
        //根据总记录数和每页显示的条数计算总页数
        long pageCount = count%pageSize == 0 ? count/pageSize : count/pageSize+1;
        //将分页数据放到pageHelper
        PageHelper<Book> bookPageHelper = new PageHelper<>(bookList, pageNum, (int) pageCount);
        return bookPageHelper;
    }
}

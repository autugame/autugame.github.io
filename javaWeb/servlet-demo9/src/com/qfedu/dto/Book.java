package com.qfedu.dto;

public class Book {
    private String bookId;
    private String bookName;
    private String bookImgPath;

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookImgPath='" + bookImgPath + '\'' +
                '}';
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImgPath() {
        return bookImgPath;
    }

    public void setBookImgPath(String bookImgPath) {
        this.bookImgPath = bookImgPath;
    }

    public Book() {
    }

    public Book(String bookId, String bookName, String bookImgPath) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookImgPath = bookImgPath;
    }
}

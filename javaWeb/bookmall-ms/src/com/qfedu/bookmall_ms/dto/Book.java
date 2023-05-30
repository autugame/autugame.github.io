package com.qfedu.bookmall_ms.dto;

public class Book {
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private double bookPrice;
    private String bookImgPath;
    private String bookDesc;
    private int bookStock;
    private int bookType;

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookImgPath='" + bookImgPath + '\'' +
                ", bookDesc='" + bookDesc + '\'' +
                ", bookStock=" + bookStock +
                ", bookType=" + bookType +
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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookImgPath() {
        return bookImgPath;
    }

    public void setBookImgPath(String bookImgPath) {
        this.bookImgPath = bookImgPath;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public int getBookStock() {
        return bookStock;
    }

    public void setBookStock(int bookStock) {
        this.bookStock = bookStock;
    }

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }

    public Book(String bookId, String bookName, String bookAuthor, double bookPrice, String bookImgPath, String bookDesc, int bookStock, int bookType) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookImgPath = bookImgPath;
        this.bookDesc = bookDesc;
        this.bookStock = bookStock;
        this.bookType = bookType;
    }

    public Book() {
    }
}

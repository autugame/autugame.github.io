package com.qfedu.bookmall_ms.utils;

import java.util.List;

public class PageHelper<T> {
    //存放当前页面数据的集合
    private List<T> lsit;
    //存放当前页码
    private int pageNum;
    //存放总页码
    private int pageCount;

    public List<T> getLsit() {
        return lsit;
    }

    public void setLsit(List<T> lsit) {
        this.lsit = lsit;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public PageHelper() {
    }

    public PageHelper(List<T> lsit, int pageNum, int pageCount) {
        this.lsit = lsit;
        this.pageNum = pageNum;
        this.pageCount = pageCount;
    }
}

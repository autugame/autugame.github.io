package com.qfedu.dao;

import com.qfedu.pojo.Classes;
import com.qfedu.utils.MyBatisUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassDaoTest {

    @Test
    void queryClass() {
        ClassDao classDao = MyBatisUtil.getMapper(ClassDao.class);
        Classes classes = classDao.queryClass(1);
        System.out.println(classes);
    }
}
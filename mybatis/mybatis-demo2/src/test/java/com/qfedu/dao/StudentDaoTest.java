package com.qfedu.dao;

import com.qfedu.pojo.Student;
import com.qfedu.utils.MyBatisUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDaoTest {

    @Test
    void queryStudentBySid() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = studentDao.queryStudentBySid("10001");
        System.out.println(student);
    }
}
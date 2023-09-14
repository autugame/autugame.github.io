package com.qfedu.dao;

import com.qfedu.pojo.Course;
import com.qfedu.utils.MyBatisUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseDaoTest {

    @Test
    void queryCourse() {
        CourseDao courseDao = MyBatisUtil.getMapper(CourseDao.class);
        Course course = courseDao.queryCourse(1);
        System.out.println(course);
    }
}
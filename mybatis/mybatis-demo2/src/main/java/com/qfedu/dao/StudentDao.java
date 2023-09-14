package com.qfedu.dao;

import com.qfedu.pojo.Student;

public interface StudentDao {
    public Student queryStudentBySid(String sid);
}

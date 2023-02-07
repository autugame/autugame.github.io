package com.qfedu.jdbc.test;

import com.qfedu.jdbc.dao.StudentDAO;
import com.qfedu.jdbc.dto.Student;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StudentDAOTest {
    //创建被测试类的对象定义成员变量
    private StudentDAO studentDAO = new StudentDAO();
    //测试insertStudent方法
    @Test
    public void testInsertStudent() {
        //准备被测试方法参数
        Student student = new Student("0002", "李四", "男", 20);
        boolean b = studentDAO.insertStudent(student);
        assertTrue(b);
    }

    @Test
    public void testQueryStudent() {
        String snum = "0001";
        Student student = studentDAO.queryStudent(snum);
        assertEquals("张三", student.getStuName());
    }

    @Test
    public void testListStudents() {
        List<Student> studentList =  studentDAO.listStudents();
        assertEquals(2, studentList.size());
    }
}
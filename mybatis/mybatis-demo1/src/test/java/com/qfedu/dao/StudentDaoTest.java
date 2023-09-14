package com.qfedu.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.pojo.Student;
import com.qfedu.utils.MyBatisUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDaoTest {

    @org.junit.jupiter.api.Test
    void insertStudent() {
            StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
            //Test method.
            Student student = new Student(0, "10004", "李四", "女", 100);
            int i = studentDao.insertStudent(student);
            System.out.println(i);
            System.out.println(student.getSid());
    }

    @org.junit.jupiter.api.Test
    void deleteStudent() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        int i = studentDao.deleteStudent("10001");
    }

    @Test
    void updateStudent(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        int i = studentDao.updateStudent(new Student(3, "10001", "赵六", "女", 18));
        assertEquals(1, i);
    }

    @Test
    void listStudents(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        //Test method.
        List<Student> list = studentDao.listStudents();
        assertNotNull(list);
        for (Student student: list) {
            System.out.println(student);
        }
    }
    @Test
    void queryStudent(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        //Test method.
        Student student = studentDao.queryStudent("10001");
        assertNotNull(student);
        System.out.println(student);
    }
    @Test
    void listStudentsByPage(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        //Test method.
        List<Student> list = studentDao.listStudentsByPage(0, 2);
        assertNotNull(list);
        for (Student student: list) {
            System.out.println(student);
        }
    }
    @Test
    void getCount(){
            StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
            //Test method.
            int count = studentDao.getCount();
            assertEquals(3, count);
    }

    @Test
    void testListStudentsByPage(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        PageHelper.startPage(1, 3);
        List<Student> students = studentDao.listStudentsByGender("女");
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        List<Student> list = pageInfo.getList();
        for (Student s : list){
            System.out.println(s);
        }
    }


}
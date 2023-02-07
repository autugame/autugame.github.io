package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.dto.Student;
import com.qfedu.jdbc.utils.DBHelper;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * students表的数据访问类
 */
public class StudentDAO {
    //公用对象
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    //1,添加学生信息
    public boolean insertStudent(Student student) {
        boolean flag = false;
        try {
            connection = DBHelper.getConnection();
            String sql = "insert into students(stu_num, stu_name, stu_gender, stu_age) values(?,?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getStuNum());
            preparedStatement.setString(2, student.getStuName());
            preparedStatement.setString(3, student.getStuGender());
            preparedStatement.setInt(4, student.getStuAge());
            int i = preparedStatement.executeUpdate();
            flag = i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(preparedStatement);
        }
        return flag;
    }
    //2,根据学号查询一个学生记录
    public Student queryStudent(String snum) {
        Student student = null;
        try {
            connection = DBHelper.getConnection();
            String sql = "select stu_num,stu_name,stu_gender,stu_age from students where stu_num=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, snum);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String stuNum = resultSet.getString("stu_num");
                String stuName = resultSet.getString("stu_name");
                String stuGender = resultSet.getString("stu_gender");
                int stuAge = resultSet.getInt("stu_age");
                student = new Student(stuNum, stuName, stuGender,stuAge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(resultSet, preparedStatement);
        }
        return student;
    }
    //3,查询多个学生信息
    public List<Student> listStudents() {
        List<Student> studentList = new ArrayList<>();
        try {
            connection = DBHelper.getConnection();
            String sql = "select stu_num,stu_name,stu_gender,stu_age from students";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String stuNum = resultSet.getString("stu_num");
                String stuName = resultSet.getString("stu_name");
                String stuGender = resultSet.getString("stu_gender");
                int stuAge = resultSet.getInt("stu_age");
                //每循环一次得到一个学生
                studentList.add(new Student(stuNum, stuName, stuGender,stuAge));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(resultSet, statement);
        }
        return studentList;
    }
}

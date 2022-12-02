package com.qf.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryJDBC2 {
    public static void main(String[] args) throws Exception {
        //1,注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2,获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_students", "root", "");
        //3,获取执行sql语句对象
        Statement statement = connection.createStatement();
        //4,执行sql语句,接收结果
        ResultSet resultSet = statement.executeQuery("select * from t_students");
        //5,处理结果e
        while (resultSet.next()) {//判断下一行是否有数据
            String stu_id = resultSet.getString("stu_id");
            String stu_name = resultSet.getString("stu_name");
            String stu_age = resultSet.getString("stu_age");
            String stu_gender = resultSet.getString("stu_gender");
            System.out.println(stu_id + "\t" + stu_name + "\t" + stu_age + "\t" + stu_gender);
        }
        //6,释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}

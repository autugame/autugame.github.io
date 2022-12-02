package com.qf.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteJDBC {
    public static void main(String[] args) throws Exception {
        //1，加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2，获得连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_students", "root", "A3452896431@a");
        //3，获得执行sql的对象
        Statement statement = connection.createStatement();
        //4，执行sql语句，并接收结果
        int result = statement.executeUpdate("delete from t_students where stu_id='1002'");
        //5，处理结果
        if (result == 1) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
        //6，释放资源
        statement.close();
        connection.close();
    }
}

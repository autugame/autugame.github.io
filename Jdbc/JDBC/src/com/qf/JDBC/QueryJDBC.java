package com.qf.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryJDBC {
    public static void main(String[] args) throws Exception {
        //1,注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2,获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_company", "root", "A3452896431@a");
        //3,获取执行sql语句对象
        Statement statement = connection.createStatement();
        //4,执行sql语句,接收结果
        //int i = statement.executeQuery("select count(*) from user");
        //5,处理结果
//        while (resultSet.next()) {//判断下一行是否有数据
//            String stu_id = resultSet.getString(1);
//            String stu_name = resultSet.getString(2);
//            String stu_age = resultSet.getString(3);
//            String stu_gender = resultSet.getString(4);
//            System.out.println(stu_id + "\t" + stu_name + "\t" + stu_age + "\t" + stu_gender);
//        }
        //6,释放资源
        //resultSet.close();
        statement.close();
        connection.close();
    }
}

package com.qf.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class TestJDBC {
    public static void main(String[] args) throws Exception {
        //1,注册驱动,加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2,获得连接
        String url = "jdbc:mysql://localhost:3306/db_students";
        String user = "root";
        String password = "A3452896431@a";
        Connection connection = DriverManager.getConnection(url, user, password);

        if (connection != null) {
            System.out.println("数据库连接成功");
        } else {
            System.out.println("连接失败");
        }

        //3,获得执行sql语句的对象
        Statement statement = connection.createStatement();

        //4,编写sql语句,执行sql语句
        String sql = "insert into t_students(stu_id,stu_name,stu_age,stu_gender) values('1002','李四',20,'男')";

        int result = statement.executeUpdate(sql);

        //5,处理接受结果
        if (result == 1) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

        //6,释放资源,先开后关
        statement.close();
        connection.close();
    }
}

package com.qf.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 增，删，改，查（单个，多个）
 */
public class PersonDaoImpl {
    //新增
    public int insert(Person person) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into person(name,age,bornDate, email,address) values(?,?,?,?,?);";
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setDate(3, DateUtils.utilToSql(person.getBornDate()));
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setString(5, person.getAddress());
            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.closeAll(connection, preparedStatement, null);
        }
    }
    //修改
    public int update(Person person) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update person set name=?,age=?,bornDate=?,email=?,address=? where id=?;";
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setDate(3, DateUtils.utilToSql(person.getBornDate()));
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setString(5, person.getAddress());
            preparedStatement.setInt(6, person.getId());
            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.closeAll(connection, preparedStatement, null);
        }
    }

    //删除
    public int delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "delete from person where id=?;";
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.closeAll(connection, preparedStatement, null);
        }
    }

    //查单个
    public Person select(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from person where id=?;";
        Person person = null;
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person = new Person();
                int pid = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date bornDate = resultSet.getDate("bornDate");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                person.setId(pid);
                person.setName(name);
                person.setAge(age);
                person.setBornDate(bornDate);
                person.setEmail(email);
                person.setAddress(address);
            }
            return person;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.closeAll(connection, preparedStatement, resultSet);
        }
    }

    //查所有
    public List<Person> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Person person = null;
        List<Person> list = null;
        String sql = "select * from person;";

        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date bornDate = resultSet.getDate("bornDate");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                person = new Person(id, name, age, bornDate, email, address);
                list.add(person);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Person select(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from person where name=?;";
        Person person = null;
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person = new Person();
                int pid = resultSet.getInt("id");
                String pname = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date bornDate = resultSet.getDate("bornDate");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                person.setId(pid);
                person.setName(pname);
                person.setAge(age);
                person.setBornDate(bornDate);
                person.setEmail(email);
                person.setAddress(address);
            }
            return person;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.closeAll(connection, preparedStatement, resultSet);
        }
    }
}

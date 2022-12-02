package com.qf.person.advanced.impl;

import com.qf.person.advanced.RowMapper;
import com.qf.person.entiry.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person getRow(ResultSet resultSet) {
        Person person = null;
        try {
            int pid = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            Date bornDate = resultSet.getDate("bornDate");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            person = new Person(pid, name, age, bornDate, email, address);
            return person;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

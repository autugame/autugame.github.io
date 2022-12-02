package com.qf.person.dao.impl;

import com.qf.person.advanced.impl.PersonRowMapper;
import com.qf.person.dao.PersonDao;
import com.qf.person.entiry.Person;
import com.qf.person.utils.DBUtils;
import com.qf.person.utils.DaoUtils;
import com.qf.person.utils.DateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    private DaoUtils<Person> daoUtils = new DaoUtils();
    @Override
    public int insert(Person person) {
        String sql = "insert into person(name,age,bornDate,email,address) values(?,?,?,?,?);";
        Object[] args = {person.getName(), person.getAge(), DateUtils.utilToSql(person.getBornDate()), person.getEmail(), person.getAddress()};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public int update(Person person) {
        String sql = "update person set name=?,age=?,bornDate=?,email=?,address=? where id=?;";
        Object[] args = {person.getName(), person.getAge(), DateUtils.utilToSql(person.getBornDate()), person.getEmail(), person.getAddress(), person.getId()};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public int delete(int id) {
        String sql = "delete from person where id=?";
        return daoUtils.commonsUpdate(sql, id);
    }

    @Override
    public Person select(int id) {
        String sql = "Select * from person where id=?";
        List<Person> list = daoUtils.commonsSelect(sql, new PersonRowMapper(), id);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Person> selectAll() {
        String sql = "Select * from person";
        List<Person> list = daoUtils.commonsSelect(sql, new PersonRowMapper());
        return list;
    }
}

package com.qf.person.dao;

import com.qf.person.entiry.Person;

import java.util.List;

public interface PersonDao {
    public int insert(Person person);
    public int update(Person person);
    public int delete(int id);
    public Person select(int id);
    public List<Person> selectAll();
}

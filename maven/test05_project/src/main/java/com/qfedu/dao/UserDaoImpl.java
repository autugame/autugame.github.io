package com.qfedu.dao;

import com.qfedu.pojo.User;
import com.qfedu.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findUsers() throws SQLException {
        //Create a connection pool object.
        DataSource dataSource = C3P0Utils.getDataSource();
        //Create a query runner object.
        QueryRunner queryRunner = new QueryRunner(dataSource);
        //Calling the query runner query method.
        return queryRunner.query("Select * from user", new BeanListHandler<>(User.class));
    }

    @Test
    public void test() throws SQLException {
        List<User> users = findUsers();
        System.out.println(users);
    }
}

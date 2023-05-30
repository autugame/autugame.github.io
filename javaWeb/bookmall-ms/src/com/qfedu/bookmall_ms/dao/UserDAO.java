package com.qfedu.bookmall_ms.dao;

import com.qfedu.bookmall_ms.dto.User;
import com.qfedu.bookmall_ms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;

public class UserDAO {
    //根据管理员登录名查询管理员信息
    public User selectUserByUserName(String userName){
        User user = null;
        try {
            String sql = "select user_id userId,user_name userName,user_pwd userPwd,real_name realName,user_gender userGender,user_tel userTel,user_desc userDesc from users where user_name=?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            user = queryRunner.query(sql, new BeanHandler<>(User.class), userName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Test
    public void TestSelectUserByUserName(){
        System.out.println(selectUserByUserName("admin"));
    }
}

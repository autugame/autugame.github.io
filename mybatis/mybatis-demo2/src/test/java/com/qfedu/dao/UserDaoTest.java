package com.qfedu.dao;

import com.qfedu.pojo.Detail;
import com.qfedu.pojo.User;
import com.qfedu.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    void insertUser() {
        User user = new User(1, "zhaoliu", "123123", "赵六", "02.jpg",  null);
        Detail detail = new Detail(0, "湖北宜昌省", "13134534521", "有个性不号",  0);

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            DetailDao detailDao = sqlSession.getMapper(DetailDao.class);
            int i = userDao.insertUser(user);
            detail.setFkUser(user.getUserId());
            int j = detailDao.insertDetail(detail);
            sqlSession.commit();

            System.out.println(j);
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void queryUser(){
        UserDao userDao = MyBatisUtil.getMapper(UserDao.class);
        User user = userDao.queryUser("zhangsan");
        System.out.println(user);
    }
}
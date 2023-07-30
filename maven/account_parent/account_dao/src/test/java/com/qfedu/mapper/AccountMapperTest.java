package com.qfedu.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class AccountMapperTest {

    private static SqlSessionFactory factory;

    @BeforeAll
    public static void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        factory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @org.junit.jupiter.api.Test
    public void transferIn() {
        SqlSession sqlSession = factory.openSession(true);

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        mapper.transferIn("aaa", 100);
    }

    @org.junit.jupiter.api.Test
    public void transferOut() {
        SqlSession sqlSession = factory.openSession(true);

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        mapper.transferOut("bbb", 100);
    }
}
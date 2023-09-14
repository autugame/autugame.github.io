package com.qfedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static final SqlSessionFactory FACTORY;
    private static final ThreadLocal<SqlSession> LOCAL = new ThreadLocal<>();
    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            FACTORY = builder.build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSessionFactory getFactory(){
        return FACTORY;
    }

    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }
    private static SqlSession getSqlSession(boolean isAutoCommit){
        SqlSession sqlSession = LOCAL.get();
        if (sqlSession == null){
            sqlSession = FACTORY.openSession(isAutoCommit);
            LOCAL.set(sqlSession);
        }
        return sqlSession;
    }

    public static <T extends Object>T getMapper(Class<T> C){
        SqlSession sqlSession = getSqlSession(true);
        return sqlSession.getMapper(C);
    }
}

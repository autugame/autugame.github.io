package com.qfedu.dao;

import com.qfedu.bean.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
public class MemberDaoTest {

    @Resource
    private MemberDao memberDao;

    @Test
    public void queryMemberById() {
        Member member = memberDao.queryMemberById(1);
        System.out.println(member);
    }
}
package com.qfedu.dao;

import com.qfedu.pojo.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberDaoTest {

    @Test
    void queryMembers() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MemberDao memberDao = (MemberDao) context.getBean("memberDao");
        List<Member> members = memberDao.queryMembers();
        System.out.println(members);
    }

    @Test
    void insertMember() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MemberDao memberDao = (MemberDao) context.getBean("memberDao");
        Member member = new Member(0, "小李", "男", 18, "四川");
        int i = memberDao.insertMember(member);
        System.out.println(i);
    }
}
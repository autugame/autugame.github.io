package com.qfedu.service.impl;

import com.qfedu.dao.MemberDao;
import com.qfedu.pojo.Member;
import com.qfedu.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    @Test
    void listMembers() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MemberService memberService = (MemberService) context.getBean("memberServiceImpl");
        List<Member> members = memberService.listMembers();
        System.out.println(members);
    }
}
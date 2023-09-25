package com.example.springboot.demo.service.impl;

import com.example.springboot.demo.dao.MemberDao;
import com.example.springboot.demo.entity.Member;
import com.example.springboot.demo.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberDao memberDao;
    @Override
    public Member AddMember(Member member) {
        int i = memberDao.insertMember(member);
        if (i > 0){
            return member;
        } else {
            return null;
        }
    }
}

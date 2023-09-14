package com.qfedu.service.impl;

import com.qfedu.dao.MemberDao;
import com.qfedu.pojo.Member;
import com.qfedu.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberDao memberDao;

    @Override
    public List<Member> listMembers() {
        return memberDao.queryMembers();
    }
}

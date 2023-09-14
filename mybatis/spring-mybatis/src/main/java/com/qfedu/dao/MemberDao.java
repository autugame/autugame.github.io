package com.qfedu.dao;

import com.qfedu.pojo.Member;

import java.util.List;

public interface MemberDao {
    public List<Member> queryMembers();
    public int insertMember(Member member);
}

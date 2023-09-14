package com.qfedu.utils;

import com.qfedu.dao.MemberDao;
import com.qfedu.pojo.Member;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        MemberDao memberDao = MyBatisUtil.getMapper(MemberDao.class);
        List<Member> members = memberDao.searchMemberByNick("花");
        System.out.println(members);
    }
}

package com.qfedu.dao;

import com.qfedu.pojo.Member;
import com.qfedu.utils.MyBatisUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberDaoTest {

    @Test
    void searchMember() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("gender", "女");
//        params.put("minAge", 18);
//        params.put("maxAge", 23);
//        params.put("city", "武汉");

        MemberDao memberDao = MyBatisUtil.getMapper(MemberDao.class);
        List<Member> members = memberDao.searchMember(params);
        System.out.println(members);
    }

    @Test
    void searchMemberByCity(){
        List<String> cities = new ArrayList<>();
        cities.add("武汉");
        cities.add("宜昌");
        MemberDao memberDao = MyBatisUtil.getMapper(MemberDao.class);

        List<Member> members = memberDao.searchMemberByCity(cities);
        System.out.println(members);
    }

    @Test
    void searchMemberByNick(){
        MemberDao memberDao = MyBatisUtil.getMapper(MemberDao.class);
        List<Member> members = memberDao.searchMemberByNick("花");
        System.out.println(members);
    }
}
package com.qfedu.dao;

import com.qfedu.pojo.Member;

import java.util.HashMap;
import java.util.List;

public interface MemberDao {
    List<Member> searchMember(HashMap<String, Object> params);
    List<Member> searchMemberByCity(List<String> cities);
    List<Member> searchMemberByNick(String keyWord);
}

package com.qfedu.service.impl;

import com.qfedu.dao.MemberDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberServiceImpl {
    @Resource
    private MemberDao memberDao;

}

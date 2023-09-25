package com.example.springboot.demo.controller;


import com.example.springboot.demo.entity.Member;
import com.example.springboot.demo.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @RequestMapping("/add")
    @ResponseBody
    public Member Add(Member member){
        return memberService.AddMember(member);
    }
}

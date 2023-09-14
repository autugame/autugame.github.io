package com.qfedu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/add")
    public void add(){
        System.out.println("----book--add");
    }

    @RequestMapping("/list")
    public void list(){
        System.out.println("----book--list");
    }
}

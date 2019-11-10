package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class test {

    @GetMapping("login")
    @ResponseBody
    public  String  test(){
        return "这是一个测试";
    }

}

package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/home")
public class test {

    @RequestMapping("/login")
    public  String  test(){
        return "login";
    }
    @RequestMapping(value = "enter" ,method = RequestMethod.POST)
    // @ResponseBody
    public  String enter(User user){
        System.out.printf(user.toString());
        return "redirect:home";
    }
    @GetMapping("home")
    public String home(User user){

        return "home";
    }
}

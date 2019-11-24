package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class home {
    @Autowired
    private  UserRepository userRepository;


    @PostMapping("/AddUser")
    @ResponseBody
    public  Map<String, String> test(User user){
        userRepository.save(user);
        Map<String, String> map = new HashMap<>();
        map.put("name","添加成功");
        return map;
    }
}
